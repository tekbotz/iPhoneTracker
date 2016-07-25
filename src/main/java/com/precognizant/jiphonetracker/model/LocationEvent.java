/*
 * @(#)LocationEvent.java $Date: May 10, 2014 4:41:55 PM $
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
package com.precognizant.jiphonetracker.model;


/**
 * Used for notifying location update listeners of location events.
 * 
 * @author Christopher Steel
 * @since May 10, 2014 4:41:55 PM
 */
public class LocationEvent {
	public enum EVENT_TYPE {LOCATION_UPDATE, DEVICE_REGISTERED, DEVICE_DEREGISTERED};

	private String deviceName;
	private String account;
	private Location location;
	private EVENT_TYPE eventType; 
	
	@SuppressWarnings("unused")
	private LocationEvent() {	
	}
	
	public LocationEvent(EVENT_TYPE eventType) {
		this.eventType = eventType;
	}

	public LocationEvent(Device device, EVENT_TYPE eventType) {
		this.deviceName = device.getName();
		this.eventType = eventType;
	}

	public LocationEvent(String deviceName, EVENT_TYPE eventType) {
		this.deviceName = deviceName;
		this.eventType = eventType;
	}
	
	/**
	 * @return the device
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param device the device to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * @return the eventType
	 */
	public EVENT_TYPE getEventType() {
		return eventType;
	}
	
	
}
