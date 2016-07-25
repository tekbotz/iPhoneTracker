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

import java.io.Serializable;
import java.util.Date;

/**
 * @author Christopher Steel - Software AG Government Solutions
 *
 * @since Jun 20, 2014 6:11:56 PM
 * @version 1.0
 */
public class DeviceImpl implements Serializable, Device {
	private Account account;
	private Features features;
	private Location location;
    private boolean canWipeAfterLock;
    private String remoteWipe;
    private boolean locFoundEnabled;
    private String deviceModel;
    private String remoteLock;
    private boolean activationLocked;
    private boolean locationEnabled;
    private String rawDeviceModel;
    private String modelDisplayName;
    private boolean lostModeCapable;
    private String id;
    private String deviceDisplayName;
    private boolean darkWake;
    private boolean locationCapable;
    private int maxMsgChar;
    private String name;
    private float batteryLevel;
    private String deviceClass;
    private boolean wipeInProgress;
    private int passcodeLength;
    private boolean isMac;
    private String snd;
    private boolean isLocating;
    private String trackingInfo;
    private String deviceColor;
    private String batteryStatus;
    private String deviceStatus;
    private Date wipedTimestamp;
    private Date lockedTimestamp;
    private Date lostTimestamp;
    private boolean lostModeEnabled;
    private boolean thisDevice;
    private String lostDevice;
    private long prsId;
	private static final long serialVersionUID = 8735864511694267647L;
    
    /**
     * Default constructor
     */
    public DeviceImpl() {
    	
    }
	
	public DeviceImpl(Account account, String name) {
		this.name = name;
		this.account = account;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getAccount()
	 */
	@Override
	public Account getAccount() {
		return account;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getFeatures()
	 */
	@Override
	public Features getFeatures() {
		return features;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setFeatures(com.precognizant.jiphonetracker.model.Features)
	 */
	@Override
	public void setFeatures(Features features) {
		this.features = features;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getLocation()
	 */
	@Override
	public Location getLocation() {
		return location;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLocation(com.precognizant.jiphonetracker.model.Location)
	 */
	@Override
	public void setLocation(Location location) {
		this.location = location;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isCanWipeAfterLock()
	 */
	@Override
	public boolean isCanWipeAfterLock() {
		return canWipeAfterLock;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setCanWipeAfterLock(boolean)
	 */
	@Override
	public void setCanWipeAfterLock(boolean canWipeAfterLock) {
		this.canWipeAfterLock = canWipeAfterLock;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getRemoteWipe()
	 */
	@Override
	public String getRemoteWipe() {
		return remoteWipe;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setRemoteWipe(java.lang.String)
	 */
	@Override
	public void setRemoteWipe(String remoteWipe) {
		this.remoteWipe = remoteWipe;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isLocFoundEnabled()
	 */
	@Override
	public boolean isLocFoundEnabled() {
		return locFoundEnabled;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLocFoundEnabled(boolean)
	 */
	@Override
	public void setLocFoundEnabled(boolean locFoundEnabled) {
		this.locFoundEnabled = locFoundEnabled;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getDeviceModel()
	 */
	@Override
	public String getDeviceModel() {
		return deviceModel;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setDeviceModel(java.lang.String)
	 */
	@Override
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getRemoteLock()
	 */
	@Override
	public String getRemoteLock() {
		return remoteLock;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setRemoteLock(java.lang.String)
	 */
	@Override
	public void setRemoteLock(String remoteLock) {
		this.remoteLock = remoteLock;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isActivationLocked()
	 */
	@Override
	public boolean isActivationLocked() {
		return activationLocked;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setActivationLocked(boolean)
	 */
	@Override
	public void setActivationLocked(boolean activationLocked) {
		this.activationLocked = activationLocked;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isLocationEnabled()
	 */
	@Override
	public boolean isLocationEnabled() {
		return locationEnabled;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLocationEnabled(boolean)
	 */
	@Override
	public void setLocationEnabled(boolean locationEnabled) {
		this.locationEnabled = locationEnabled;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getRawDeviceModel()
	 */
	@Override
	public String getRawDeviceModel() {
		return rawDeviceModel;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setRawDeviceModel(java.lang.String)
	 */
	@Override
	public void setRawDeviceModel(String rawDeviceModel) {
		this.rawDeviceModel = rawDeviceModel;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getModelDisplayName()
	 */
	@Override
	public String getModelDisplayName() {
		return modelDisplayName;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setModelDisplayName(java.lang.String)
	 */
	@Override
	public void setModelDisplayName(String modelDisplayName) {
		this.modelDisplayName = modelDisplayName;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isLostModeCapable()
	 */
	@Override
	public boolean isLostModeCapable() {
		return lostModeCapable;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLostModeCapable(boolean)
	 */
	@Override
	public void setLostModeCapable(boolean lostModeCapable) {
		this.lostModeCapable = lostModeCapable;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getId()
	 */
	@Override
	public String getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setId(java.lang.String)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getDeviceDisplayName()
	 */
	@Override
	public String getDeviceDisplayName() {
		return deviceDisplayName;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setDeviceDisplayName(java.lang.String)
	 */
	@Override
	public void setDeviceDisplayName(String deviceDisplayName) {
		this.deviceDisplayName = deviceDisplayName;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isDarkWake()
	 */
	@Override
	public boolean isDarkWake() {
		return darkWake;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setDarkWake(boolean)
	 */
	@Override
	public void setDarkWake(boolean darkWake) {
		this.darkWake = darkWake;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isLocationCapable()
	 */
	@Override
	public boolean isLocationCapable() {
		return locationCapable;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLocationCapable(boolean)
	 */
	@Override
	public void setLocationCapable(boolean locationCapable) {
		this.locationCapable = locationCapable;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getMaxMsgChar()
	 */
	@Override
	public long getMaxMsgChar() {
		return maxMsgChar;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setMaxMsgChar(int)
	 */
	@Override
	public void setMaxMsgChar(int maxMsgChar) {
		this.maxMsgChar = maxMsgChar;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getBatteryLevel()
	 */
	@Override
	public float getBatteryLevel() {
		return batteryLevel;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setBatteryLevel(float)
	 */
	@Override
	public void setBatteryLevel(float batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getDeviceClass()
	 */
	@Override
	public String getDeviceClass() {
		return deviceClass;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setDeviceClass(java.lang.String)
	 */
	@Override
	public void setDeviceClass(String deviceClass) {
		this.deviceClass = deviceClass;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isWipeInProgress()
	 */
	@Override
	public boolean isWipeInProgress() {
		return wipeInProgress;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setWipeInProgress(boolean)
	 */
	@Override
	public void setWipeInProgress(boolean wipeInProgress) {
		this.wipeInProgress = wipeInProgress;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getPasscodeLength()
	 */
	@Override
	public int getPasscodeLength() {
		return passcodeLength;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setPasscodeLength(int)
	 */
	@Override
	public void setPasscodeLength(int passcodeLength) {
		this.passcodeLength = passcodeLength;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isMac()
	 */
	@Override
	public boolean isMac() {
		return isMac;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setMac(boolean)
	 */
	@Override
	public void setMac(boolean isMac) {
		this.isMac = isMac;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getSnd()
	 */
	@Override
	public String getSnd() {
		return snd;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setSnd(java.lang.String)
	 */
	@Override
	public void setSnd(String snd) {
		this.snd = snd;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isLocating()
	 */
	@Override
	public boolean isLocating() {
		return isLocating;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLocating(boolean)
	 */
	@Override
	public void setLocating(boolean isLocating) {
		this.isLocating = isLocating;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getTrackingInfo()
	 */
	@Override
	public String getTrackingInfo() {
		return trackingInfo;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setTrackingInfo(java.lang.String)
	 */
	@Override
	public void setTrackingInfo(String trackingInfo) {
		this.trackingInfo = trackingInfo;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getDeviceColor()
	 */
	@Override
	public String getDeviceColor() {
		return deviceColor;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setDeviceColor(java.lang.String)
	 */
	@Override
	public void setDeviceColor(String deviceColor) {
		this.deviceColor = deviceColor;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getBatteryStatus()
	 */
	@Override
	public String getBatteryStatus() {
		return batteryStatus;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setBatteryStatus(java.lang.String)
	 */
	@Override
	public void setBatteryStatus(String batteryStatus) {
		this.batteryStatus = batteryStatus;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getDeviceStatus()
	 */
	@Override
	public String getDeviceStatus() {
		return deviceStatus;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setDeviceStatus(java.lang.String)
	 */
	@Override
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getWipedTimestamp()
	 */
	@Override
	public Date getWipedTimestamp() {
		return wipedTimestamp;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setWipedTimestamp(java.util.Date)
	 */
	@Override
	public void setWipedTimestamp(Date wipedTimestamp) {
		this.wipedTimestamp = wipedTimestamp;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getLockedTimestamp()
	 */
	@Override
	public Date getLockedTimestamp() {
		return lockedTimestamp;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLockedTimestamp(java.util.Date)
	 */
	@Override
	public void setLockedTimestamp(Date lockedTimestamp) {
		this.lockedTimestamp = lockedTimestamp;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getLostTimestamp()
	 */
	@Override
	public Date getLostTimestamp() {
		return lostTimestamp;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLostTimestamp(java.util.Date)
	 */
	@Override
	public void setLostTimestamp(Date lostTimestamp) {
		this.lostTimestamp = lostTimestamp;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isLostModeEnabled()
	 */
	@Override
	public boolean isLostModeEnabled() {
		return lostModeEnabled;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLostModeEnabled(boolean)
	 */
	@Override
	public void setLostModeEnabled(boolean lostModeEnabled) {
		this.lostModeEnabled = lostModeEnabled;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#isThisDevice()
	 */
	@Override
	public boolean isThisDevice() {
		return thisDevice;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setThisDevice(boolean)
	 */
	@Override
	public void setThisDevice(boolean thisDevice) {
		this.thisDevice = thisDevice;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getLostDevice()
	 */
	@Override
	public String getLostDevice() {
		return lostDevice;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setLostDevice(java.lang.String)
	 */
	@Override
	public void setLostDevice(String lostDevice) {
		this.lostDevice = lostDevice;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#getPrsId()
	 */
	@Override
	public long getPrsId() {
		return prsId;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#setPrsId(long)
	 */
	@Override
	public void setPrsId(long prsId) {
		this.prsId = prsId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Device#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceImpl other = (DeviceImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
