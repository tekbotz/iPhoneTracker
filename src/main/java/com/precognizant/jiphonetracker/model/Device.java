package com.precognizant.jiphonetracker.model;

import java.util.Date;

public interface Device {

	/**
	 * @return the account
	 */
	public Account getAccount();

	/**
	 * @return the features
	 */
	public Features getFeatures();

	/**
	 * @param features the features to set
	 */
	public void setFeatures(Features features);

	/**
	 * @return the location
	 */
	public Location getLocation();

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location);

	/**
	 * @return the canWipeAfterLock
	 */
	public boolean isCanWipeAfterLock();

	/**
	 * @param canWipeAfterLock the canWipeAfterLock to set
	 */
	public void setCanWipeAfterLock(boolean canWipeAfterLock);

	/**
	 * @return the remoteWipe
	 */
	public String getRemoteWipe();

	/**
	 * @param remoteWipe the remoteWipe to set
	 */
	public void setRemoteWipe(String remoteWipe);

	/**
	 * @return the locFoundEnabled
	 */
	public boolean isLocFoundEnabled();

	/**
	 * @param locFoundEnabled the locFoundEnabled to set
	 */
	public void setLocFoundEnabled(boolean locFoundEnabled);

	/**
	 * @return the deviceModel
	 */
	public String getDeviceModel();

	/**
	 * @param deviceModel the deviceModel to set
	 */
	public void setDeviceModel(String deviceModel);

	/**
	 * @return the remoteLock
	 */
	public String getRemoteLock();

	/**
	 * @param remoteLock the remoteLock to set
	 */
	public void setRemoteLock(String remoteLock);

	/**
	 * @return the activationLocked
	 */
	public boolean isActivationLocked();

	/**
	 * @param activationLocked the activationLocked to set
	 */
	public void setActivationLocked(boolean activationLocked);

	/**
	 * @return the locationEnabled
	 */
	public boolean isLocationEnabled();

	/**
	 * @param locationEnabled the locationEnabled to set
	 */
	public void setLocationEnabled(boolean locationEnabled);

	/**
	 * @return the rawDeviceModel
	 */
	public String getRawDeviceModel();

	/**
	 * @param rawDeviceModel the rawDeviceModel to set
	 */
	public void setRawDeviceModel(String rawDeviceModel);

	/**
	 * @return the modelDisplayName
	 */
	public String getModelDisplayName();

	/**
	 * @param modelDisplayName the modelDisplayName to set
	 */
	public void setModelDisplayName(String modelDisplayName);

	/**
	 * @return the lostModeCapable
	 */
	public boolean isLostModeCapable();

	/**
	 * @param lostModeCapable the lostModeCapable to set
	 */
	public void setLostModeCapable(boolean lostModeCapable);

	/**
	 * @return the id
	 */
	public String getId();

	/**
	 * @param id the id to set
	 */
	public void setId(String id);

	/**
	 * @return the deviceDisplayName
	 */
	public String getDeviceDisplayName();

	/**
	 * @param deviceDisplayName the deviceDisplayName to set
	 */
	public void setDeviceDisplayName(String deviceDisplayName);

	/**
	 * @return the darkWake
	 */
	public boolean isDarkWake();

	/**
	 * @param darkWake the darkWake to set
	 */
	public void setDarkWake(boolean darkWake);

	/**
	 * @return the locationCapable
	 */
	public boolean isLocationCapable();

	/**
	 * @param locationCapable the locationCapable to set
	 */
	public void setLocationCapable(boolean locationCapable);

	/**
	 * @return the maxMsgChar
	 */
	public long getMaxMsgChar();

	/**
	 * @param maxMsgChar the maxMsgChar to set
	 */
	public void setMaxMsgChar(int maxMsgChar);

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name the name to set
	 */
	public void setName(String name);

	/**
	 * @return the batteryLevel
	 */
	public float getBatteryLevel();

	/**
	 * @param batteryLevel the batteryLevel to set
	 */
	public void setBatteryLevel(float batteryLevel);

	/**
	 * @return the deviceClass
	 */
	public String getDeviceClass();

	/**
	 * @param deviceClass the deviceClass to set
	 */
	public void setDeviceClass(String deviceClass);

	/**
	 * @return the wipeInProgress
	 */
	public boolean isWipeInProgress();

	/**
	 * @param wipeInProgress the wipeInProgress to set
	 */
	public void setWipeInProgress(boolean wipeInProgress);

	/**
	 * @return the passcodeLength
	 */
	public int getPasscodeLength();

	/**
	 * @param passcodeLength the passcodeLength to set
	 */
	public void setPasscodeLength(int passcodeLength);

	/**
	 * @return the isMac
	 */
	public boolean isMac();

	/**
	 * @param isMac the isMac to set
	 */
	public void setMac(boolean isMac);

	/**
	 * @return the snd
	 */
	public String getSnd();

	/**
	 * @param snd the snd to set
	 */
	public void setSnd(String snd);

	/**
	 * @return the isLocating
	 */
	public boolean isLocating();

	/**
	 * @param isLocating the isLocating to set
	 */
	public void setLocating(boolean isLocating);

	/**
	 * @return the trackingInfo
	 */
	public String getTrackingInfo();

	/**
	 * @param trackingInfo the trackingInfo to set
	 */
	public void setTrackingInfo(String trackingInfo);

	/**
	 * @return the deviceColor
	 */
	public String getDeviceColor();

	/**
	 * @param deviceColor the deviceColor to set
	 */
	public void setDeviceColor(String deviceColor);

	/**
	 * @return the batteryStatus
	 */
	public String getBatteryStatus();

	/**
	 * @param batteryStatus the batteryStatus to set
	 */
	public void setBatteryStatus(String batteryStatus);

	/**
	 * @return the deviceStatus
	 */
	public String getDeviceStatus();

	/**
	 * @param deviceStatus the deviceStatus to set
	 */
	public void setDeviceStatus(String deviceStatus);

	/**
	 * @return the wipedTimestamp
	 */
	public Date getWipedTimestamp();

	/**
	 * @param wipedTimestamp the wipedTimestamp to set
	 */
	public void setWipedTimestamp(Date wipedTimestamp);

	/**
	 * @return the lockedTimestamp
	 */
	public Date getLockedTimestamp();

	/**
	 * @param lockedTimestamp the lockedTimestamp to set
	 */
	public void setLockedTimestamp(Date lockedTimestamp);

	/**
	 * @return the lostTimestamp
	 */
	public Date getLostTimestamp();

	/**
	 * @param lostTimestamp the lostTimestamp to set
	 */
	public void setLostTimestamp(Date lostTimestamp);

	/**
	 * @return the lostModeEnabled
	 */
	public boolean isLostModeEnabled();

	/**
	 * @param lostModeEnabled the lostModeEnabled to set
	 */
	public void setLostModeEnabled(boolean lostModeEnabled);

	/**
	 * @return the thisDevice
	 */
	public boolean isThisDevice();

	/**
	 * @param thisDevice the thisDevice to set
	 */
	public void setThisDevice(boolean thisDevice);

	/**
	 * @return the lostDevice
	 */
	public String getLostDevice();

	/**
	 * @param lostDevice the lostDevice to set
	 */
	public void setLostDevice(String lostDevice);

	/**
	 * @return the prsId
	 */
	public long getPrsId();

	/**
	 * @param prsId the prsId to set
	 */
	public void setPrsId(long prsId);

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode();

	public void setAccount(Account account);

}