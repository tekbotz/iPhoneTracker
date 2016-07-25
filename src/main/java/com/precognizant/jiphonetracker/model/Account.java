package com.precognizant.jiphonetracker.model;

import java.util.Vector;

public interface Account {

	/**
	 * @return the devices
	 */
	public Vector<Device> getDevices();

	/**
	 * @param devices the devices to set
	 */
	public void setDevices(Vector<Device> devices);

	public void addDevice(Device device);

	/**
	 * @return the userInfo
	 */
	public UserInfo getUserInfo();

	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(UserInfo userInfo);

	/**
	 * @return the username
	 */
	public String getUsername();

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username);

	/**
	 * @return the password
	 */
	public String getCredentials();

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password);

	public String toString();

	public void setRedirectHost(String redirectHost);
	
	public String getRedirectHost();

}