/*
 * Copyright 2014 Software AG Government Solutions
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Softwre AG
 * Government Solutions ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Software AG Government Soltuions.
 *
 * SOFTWARE AG GS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. SOFTWARE AG GS SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 */

package com.precognizant.jiphonetracker.model;

import java.util.Vector;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Christopher Steel - Software AG Government Solutions
 *
 * @since Jun 20, 2014 6:33:28 PM
 * @version 1.0
 */
public class AccountImpl implements Account {
	private Vector<Device> devices = new Vector<Device>();
	private UserInfo userInfo;
	private String username;
	private String password;
	private String credentials;
	private Base64 base64 = new Base64();
	private String redirectHost;

	@SuppressWarnings("unused")
	private AccountImpl() {
	}
	
	public AccountImpl(String username, String password) {
		this.username = username;
		this.password = password;
		setCredentials(username, password);
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Account#getDevices()
	 */
	@Override
	public Vector<Device> getDevices() {
		return devices;
	}

	public void setDevices(Vector<Device> devices) {
		this.devices = devices;
	}
	
	public void addDevice(Device device) {
		this.devices.add(device);
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Account#getUserInfo()
	 */
	@Override
	public UserInfo getUserInfo() {
		return userInfo;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Account#setUserInfo(com.precognizant.jiphonetracker.model.UserInfo)
	 */
	@Override
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Account#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Account#setUsername(java.lang.String)
	 */
	@Override
	public void setUsername(String username) {
		this.username = username;
		if(this.password != null)
			setCredentials(username, password);
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Account#getCredentials()
	 */
	@Override
	public String getCredentials() {
		return credentials;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Account#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
		if(this.username != null)
			setCredentials(username, password);
	}
	
	private void setCredentials(String username, String password) {
		String pair = username + ":" + password;
		credentials = new String(base64.encode(pair.getBytes()));
	}
	
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Account#toString()
	 */
	@Override
	public String toString() {
		return this.getUsername() + " " + this.getUserInfo();
	}

	@Override
	public void setRedirectHost(String redirectHost) {
		this.redirectHost = redirectHost;
	}

	@Override
	public String getRedirectHost() {
		return redirectHost;
	}

}
