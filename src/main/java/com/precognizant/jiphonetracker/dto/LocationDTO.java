/*
 * @(#)LocationDTO.java $Date: May 10, 2014 4:41:55 PM $
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
package com.precognizant.jiphonetracker.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Data Transfer Object class for holding phone location data.
 * 
 * @author Christopher Steel
 * @since May 10, 2014 4:41:55 PM
 */
public class LocationDTO {
	private Date dateTime = null;
	private String date = null;
	private String time = null;
	private double horizontalAccuracy = -1.0d;
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM d yyyy");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
	private String deviceName;
	private double lat;
	private double lon;

	/**
	 * Default constructor
	 */
	public LocationDTO() {		
	}
	
	/**
	 * Overloaded constructor.
	 * 
	 * @param deviceName Name of the device associated with the location data.
	 */
	public LocationDTO(String deviceName) {
		setDeviceName(deviceName);
	}
	
	/**
	 * Overloaded constructor.
	 * 
	 * @param deviceName Name of the device associated with the location data.
	 * @param lat The device's latitude
	 * @param lon The device's longitude
	 */
	public LocationDTO(String deviceName, double lat, double lon) {
		this(deviceName);
		this.lat = lat;
		this.lon = lon;
		setDate(new Date(System.currentTimeMillis()));
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDate(Date dateTime) {
		this.dateTime = dateTime;
		date = dateFormat.format(dateTime);
		time = timeFormat.format(dateTime);
	}

	public String getDateTimeString() {
		return dateTimeFormat.format(dateTime);
	}

	/**
	 * @return The horizonatalAccuracy of the location measurement in meters.
	 */
	public double getHorizontalAccuracy() {
		return horizontalAccuracy;
	}

	/**
	 * @param horizontalAccuracy the horizonatalAccuracy of the location measurement in meters.
	 */
	public void setHorizontalAccuracy(double horizontalAccuracy) {
		this.horizontalAccuracy = horizontalAccuracy;
	}

	/**
	 * Returns the location object as a String using comma separated values.
	 * 
	 * @return The location object as a comma separated value String.
	 */ 
	public String toString() {
		return (new StringBuilder()).append(getDeviceName()).append(", ").append(getDateTimeString()).append(", ").append(getLat()).append(", ").append(getLon()).append(", ")
				.append(getHorizontalAccuracy()).toString();
	}

}
