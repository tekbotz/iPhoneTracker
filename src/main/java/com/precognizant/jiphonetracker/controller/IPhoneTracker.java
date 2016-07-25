/*
 * @(#)IPhoneTracker.java $Date: May 10, 2014 4:41:55 PM $
 * 
 * Copyright 2014 Precognizant, Inc. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Precognizant,
 * Inc. ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with Precognizant.
 * 
 * PRECOGNIZANT MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 * NON-INFRINGEMENT. PRECOGNIZANT SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY
 * LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES.
 * 
 */
package com.precognizant.jiphonetracker.controller;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.KeyStore;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Vector;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.precognizant.jiphonetracker.model.Account;
import com.precognizant.jiphonetracker.model.AccountImpl;
import com.precognizant.jiphonetracker.model.Device;
import com.precognizant.jiphonetracker.model.Location;
import com.precognizant.jiphonetracker.model.LocationEvent;
import com.precognizant.jiphonetracker.model.LocationEvent.EVENT_TYPE;
import com.precognizant.jiphonetracker.model.LocationListenerManager;
import com.precognizant.jiphonetracker.util.JSONConverter;

/**
 * <pre>
 * This class is responsible for connecting to the Apple iCloud service, retrieving the status information
 * for each of the devices registered to the account associated with the credentials entered, and parsing
 * the JSON_REQUEST response into location data. This class implements the Runnable interface and once started
 * will continue to connect to iCloud and poll the status of the devices according to the polling interval.
 * 
 * The class also provides a notification registration method for listeners to receive location update
 * notifications. It will use the horizontal accuracy value to filter out measurement errors and only 
 * notify of location change that is likely due to an actual change in location and not just the measurement
 * error associated with GPS tracking.
 * </pre>
 *  
 * @author Christopher Steel
 *
 * @since May 10, 2014 4:41:55 PM
 *  
 */
@SuppressWarnings("deprecation")
public class IPhoneTracker extends LocationListenerManager implements Runnable {
	private static final String PATH_PREFIX = "/fmipservice/device/";
	private static final String PATH_SUFFIX = "/initClient";
	private static final String HTTPS_PREFIX = "https://";
	private static final String ICLOUD_HOST = "fmipmobile.icloud.com";
	private static final String JSON_REQUEST = "{\"clientContext\":{\"appName\":\"FindMyiPhone\",\"appVersion\":\"1.4\",\"buildVersion\":\"145\",\"deviceUDID\":\"0000000000000000000000000000000000000000\",\"inactiveTime\":2147483647,\"osVersion\":\"4.2.1\",\"personID\":0,\"productType\":\"iPad1,1\"}}";
	private static final String SCHEME_NAME = "https";
	private static final int SSL_PORT = 443;

	private static IPhoneTracker instance = null;
	private DefaultHttpClient httpClient = new DefaultHttpClient();
	private Logger log = Logger.getLogger(IPhoneTracker.class);

	private boolean useProxy = false;
	private int proxyPort = 58495;
	private String proxyHost = "127.0.0.1";
	private String certFileName = "certs/charles-proxy-ssl-proxying-certificate.crt";

	private long pollingInterval = 120000; //Default every 3 minutes
	private String locationFileName = "iPhoneLocations.csv";
	private StringEntity stringEntity;

	private HashMap<String, Location> lastLocations = new HashMap<String, Location>();
	private Vector<AccountImpl> accounts = new Vector<AccountImpl>();

	/**
	 * Default constructor.
	 * 
	 */
	protected IPhoneTracker() {
		// Initialize LocationListenerManager
		super();
		try {
			stringEntity = new StringEntity(JSON_REQUEST);
		}
		catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Exception creating StringEntity: " + e, e);
		}
		stringEntity.setContentType("application/json");
		if (useProxy) {
			enableProxy();
		}
	}

	/**
	 * Singleton method for obtaining the instance.
	 * 
	 * @returns The single instance of an IPhoneTracker class
	 */
	public static synchronized IPhoneTracker getInstance() {
		if (instance == null)
			instance = new IPhoneTracker();
		return instance;
	}
	
	public void run() {
		Writer bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(locationFileName, true), "UTF-8"));
			
			while (true) {
				for (Account account : accounts) {
					getDevices(account);
					for (Device device : account.getDevices()) {
						if (!this.getRegisteredDevices().contains(device.getName()))
							registerDevice(device.getName());
						filterUpdate(device);
						Location loc = device.getLocation();
						if (null != loc) {
							log.info("Location update: " + device.getAccount().getUsername() + " : " + device.getLocation());
							bw.write(loc.toString() + "\n");
						}
					}
					bw.flush();
					Thread.sleep(pollingInterval);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					throw new RuntimeException("Exception closing File Writer: " + e, e);
				}
		}
	}
	
	/**
	 * Filters the location notifications so that locations updates that are within the horizontal
	 * accuracy radius of the last location update are not broadcast to listeners. Only location
	 * updates that exceed the horizontal accuracy are sent so that listeners receive updates only 
	 * when the locations are truly changing. If the location is determined to have moved beyond
	 * the accuracy radius, this method will call notifyListeners with a LOCATION_UPDATE event.
	 * 
	 * @param device The device to filter
	 * @param location The latest location
	 */
	protected void filterUpdate(Device device) {
		Location location = device.getLocation();
		if(device == null || location == null ) {
			//log.warn("Device or location is null");
			return;
		}
		Location lastLoc = this.lastLocations.get(device);
		//FIXME: fix this
		if(lastLoc == null || lastLoc != location) {
			LocationEvent event = new LocationEvent(device, EVENT_TYPE.LOCATION_UPDATE);
			event.setLocation(location);
			this.notifyListeners(event);
			if(log.isDebugEnabled() && lastLoc != null)
				log.debug("Location updated: Lat difference: " + Math.abs(location.getLatitude()-lastLoc.getLatitude()) + " Lon difference: " + Math.abs(location.getLongitude() - lastLoc.getLongitude()) + " Distance: ");
		}
		else {
			if(log.isDebugEnabled())
				log.debug("Location not updated: Lat difference: " + Math.abs(location.getLatitude()-lastLoc.getLatitude()) + " Lon difference: " + Math.abs(location.getLongitude() - lastLoc.getLongitude()));
		}
		this.lastLocations.put(device.getName(), location);
	}
	
	private void setRedirectHost(Account account) throws Exception {
		HttpPost request = new HttpPost(HTTPS_PREFIX + ICLOUD_HOST + PATH_PREFIX + account.getUsername() + PATH_SUFFIX);
		HttpResponse response = null;

		request.setEntity(stringEntity);
		setHeaders(request, ICLOUD_HOST, account.getCredentials());
		try {
			response = httpClient.execute(request);
			if(log.isDebugEnabled())
				log.debug("Redirect Response: " + response);
	        // The first request will result in a redirect with the redirect host specified in the X-Apple-MMe-Host header value
	        if(response.getStatusLine().getStatusCode() == 401) {
	        	log.warn("Authorization exception for credentials, please verify account login information and try again.");
	        	throw new SecurityException("Unauthorized");
	        }
	        
	        if(response.getStatusLine().getStatusCode() != 330) {
	        	log.error("Initial request did not return a 330 Redirect response. Aborting location request. Returned: " + response.getStatusLine().getStatusCode());
	        	throw new IOException("Initial request did not return a 330 Redirect response. Aborting location request. Returned: " + response.getStatusLine().getStatusCode());
	        }
	                
	        String redirectHost = response.getFirstHeader("X-Apple-MMe-Host").getValue();
	        if(redirectHost == null) {
	        	throw new IOException("Could not find redirect URL in header value for X-Apple-MMe-Host. Aborting location request.");
	        }
	        account.setRedirectHost(redirectHost);
		}
		catch(Exception e) {
			log.error("Exception executing redirect request: " + e.getMessage());
		}
		request.releaseConnection();

	}

	protected void getDevices(Account account) throws Exception {
		if (account.getRedirectHost() == null) {
			throw new Exception("Exception: Redirect host not set for account.");
		}

		// Now send the request. This will return all available info about all
		// registered devices for the iCloud account.
		String username = account.getUsername();
		String credentials = account.getCredentials();
		if (log.isDebugEnabled())
			log.debug("Getting devices for account: " + username);
		
		HttpResponse response = null;

		HttpPost request = new HttpPost(HTTPS_PREFIX + account.getRedirectHost() + PATH_PREFIX + username + PATH_SUFFIX);
		request.setEntity(stringEntity);
		setHeaders(request, account.getRedirectHost(), credentials);

		response = httpClient.execute(request);
		if (log.isDebugEnabled())
			log.debug("Device Status Response: " + response.getStatusLine());

		// Took a while to figure out that the response was GZipped. Need to inflate it.
		HttpEntity gzipEntity = response.getEntity();
		GzipDecompressingEntity entity = new GzipDecompressingEntity(gzipEntity);
		String result = EntityUtils.toString(entity, "UTF-8");
		if (log.isDebugEnabled())
			log.debug("Device Status Response: " + result);

		Vector<Device> devices = JSONConverter.getDevices(account, result);
		account.setDevices(devices);  //FIXME: Do we replace or update?

		if (log.isInfoEnabled())
			log.info("Devices: " + devices);
	}
	
	protected void setHeaders(HttpPost request, String host, String credentials) {
		request.addHeader("Content-Type", "application/json; charset=utf-8");
		request.addHeader("X-Apple-Find-Api-Ver", "2.0");
		request.addHeader("X-Apple-Authscheme", "UserIdGuest");
		request.addHeader("X-Apple-Realm-Support", "1.2");
		request.addHeader("User-Agent", "Find iPhone/1.1 MeKit (iPad: iPhone OS/4.2.1)");
		request.addHeader("X-Client-Name", "iPad");
		request.addHeader("X-Client-UUID", "0cf3dc501ff812adb0b202baed4f37274b210853");
		request.addHeader("Accept-Language", "en-us");
	    request.addHeader("Connection", "keep-alive");
	    request.addHeader("Proxy-Connection", "keep-alive");
	    request.addHeader("Accept-Encoding", "gzip, deflate");
	    request.addHeader("Host", host);
	    request.addHeader("Accept", "*/*");
	    request.addHeader("Authorization", "Basic " + credentials);
	}
	
	public void enableProxy() {
		HttpHost proxy = new HttpHost(proxyHost, proxyPort);
		httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null);

			InputStream certStream = new FileInputStream(certFileName);
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate) cf.generateCertificate(certStream);
			certStream.close();
			trustStore.setCertificateEntry("proxy-cert", cert);

			SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);
			httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme(SCHEME_NAME, SSL_PORT, socketFactory));
			log.info("Proxy configuration complete.");
		}
		catch (Exception e) {
			log.warn("Exception creating SSL Socket Factory for SSL Proxy debugging: " + e);
			throw new RuntimeException(e);
		}
	}
	
	public void addAccount(String username, String password) throws Exception {
		AccountImpl account = new AccountImpl(username, password);
		accounts.add(account);
		try {
			setRedirectHost(account);
		} 
		catch (SecurityException e) {
			log.warn("Invalid credentials set");
			throw e;
		}
		log.info("Added account: " + account);
	}
	
/*	public void removeAccount(String username) {
		accounts.remove(username);
		for(String device : userDevices.get(username)) {
			deregister(device);
			removeDevice(device);
		}
		userDevices.remove(username);
	}
	
	public void removeDevice(String deviceName) {
		devices.remove(deviceName);
	}
*/
	/**
	 * @return the useProxy
	 */
	public boolean isUseProxy() {
		return useProxy;
	}

	/**
	 * @param useProxy the useProxy to set
	 */
	public void setUseProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}

	/**
	 * @return the pollingInterval
	 */
	public long getPollingInterval() {
		return pollingInterval;
	}

	/**
	 * @param pollingInterval the pollingInterval to set
	 */
	public void setPollingInterval(long pollingInterval) {
		this.pollingInterval = pollingInterval;
	}

	/**
	 * @return the proxyPort
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * @param proxyPort the proxyPort to set
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	/**
	 * @return the proxyHost
	 */
	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * @param proxyHost the proxyHost to set
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	/**
	 * @return the certFileName
	 */
	public String getCertFileName() {
		return certFileName;
	}

	/**
	 * @param certFileName the certFileName to set
	 */
	public void setCertFileName(String certFileName) {
		this.certFileName = certFileName;
	}

	public static void main(String[] args)  {
		IPhoneTracker locator = IPhoneTracker.getInstance();

		/*
		Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        */
        try {
        	/*
			username = 	c.readLine("Please enter your iCloud account name (ex. jdoe@yahoo.com): ");
			if(username.length() < 3)
				throw new Exception("Invalid account name entered");
				
			password = new String(c.readPassword("Please enter your iCloud account password (ex. Password1): "));
			if(password.length() < 5)
				throw new Exception("Invalid password entered");
			*/
        	
			locator.addAccount("iansteel22@gmail.com", "Woodloch22");
			//locator.addAccount("csteel@fortmoon.com", "*S3eker5");
			locator.addAccount("bsteel364@icloud.com", "Woodloch31");
			locator.run();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}


