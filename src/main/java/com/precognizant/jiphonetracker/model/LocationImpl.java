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
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Christopher Steel - Software AG Government Solutions
 *
 * @since Jun 20, 2014 6:12:38 PM
 * @version 1.0
 */
public class LocationImpl implements Serializable, Location {
	private Device device;
	private long timeStamp;
    private String locationType;
    private String positionType;
    private float horizontalAccuracy;
    private boolean locationFinished;
    private boolean isInaccurate;
    private double longitude;
    private double latitude;
    private boolean isOld;
    @SuppressWarnings("unused")
	private int month;
    @SuppressWarnings("unused")
    private int dayOfWeek;
    @SuppressWarnings("unused")
    private int dayOfMonth;
    @SuppressWarnings("unused")
    private int year;
    @SuppressWarnings("unused")
    private int hour;
    @SuppressWarnings("unused")
    private int minute;
	private Calendar calendar = Calendar.getInstance();
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
	private static final long serialVersionUID = -3298446018992575862L;
	private static final double METER_MULTIPLIER = 60 * 1.1515 * 1609.344; //Meters
    
	
	public LocationImpl() {
		
	}
	
	public LocationImpl(Device device) {
		this.device = device;
	}
	
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getDevice()
	 */
	@Override
	public Device getDevice() {
		return device;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getTimeStamp()
	 */
	@Override
	public long getTimeStamp() {
		return timeStamp;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#setTimeStamp(long)
	 */
	@Override
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
		this.calendar.setTimeInMillis(timeStamp);
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getLocationType()
	 */
	@Override
	public String getLocationType() {
		return locationType;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#setLocationType(java.lang.String)
	 */
	@Override
	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getPositionType()
	 */
	@Override
	public String getPositionType() {
		return positionType;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#setPositionType(java.lang.String)
	 */
	@Override
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getHorizontalAccuracy()
	 */
	@Override
	public float getHorizontalAccuracy() {
		return horizontalAccuracy;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#setHorizontalAccuracy(float)
	 */
	@Override
	public void setHorizontalAccuracy(float horizontalAccuracy) {
		this.horizontalAccuracy = horizontalAccuracy;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#isLocationFinished()
	 */
	@Override
	public boolean isLocationFinished() {
		return locationFinished;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#setLocationFinished(boolean)
	 */
	@Override
	public void setLocationFinished(boolean locationFinished) {
		this.locationFinished = locationFinished;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#isInaccurate()
	 */
	@Override
	public boolean isInaccurate() {
		return isInaccurate;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#setInaccurate(boolean)
	 */
	@Override
	public void setInaccurate(boolean isInaccurate) {
		this.isInaccurate = isInaccurate;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getLongitude()
	 */
	@Override
	public double getLongitude() {
		return longitude;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#setLongitude(double)
	 */
	@Override
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getLatitude()
	 */
	@Override
	public double getLatitude() {
		return latitude;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#setLatitude(double)
	 */
	@Override
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#isOld()
	 */
	@Override
	public boolean isOld() {
		return isOld;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#setOld(boolean)
	 */
	@Override
	public void setOld(boolean isOld) {
		this.isOld = isOld;
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getMonth()
	 */
	@Override
	public int getMonth() {
		return calendar.get(Calendar.MONTH);
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getDayOfWeek()
	 */
	@Override
	public int getDayOfWeek() {
		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getDayOfMonth()
	 */
	@Override
	public int getDayOfMonth() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getYear()
	 */
	@Override
	public int getYear() {
		return calendar.get(Calendar.YEAR);
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getHour()
	 */
	@Override
	public int getHour() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getMinute()
	 */
	@Override
	public int getMinute() {
		return calendar.get(Calendar.MINUTE);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationImpl other = (LocationImpl) obj;
/*		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
*/

		double theta = longitude - other.longitude;
		double dist = Math.sin(Math.toRadians(latitude)) * Math.sin(Math.toRadians(other.latitude)) + Math.cos(Math.toRadians(latitude))
				* Math.cos(Math.toRadians(other.latitude)) * Math.cos(Math.toRadians(theta));
		dist = Math.acos(dist);
		dist = Math.toDegrees(dist);
		dist *= METER_MULTIPLIER;

		if(dist > this.horizontalAccuracy) {
			return false;
		}
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#getDateTimeString()
	 */
	@Override
	public String getDateTimeString() {
		return dateTimeFormat.format(this.calendar.getTime());
	}
	
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.Location#toString()
	 */ 
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
//		sb.append(getDevice().getAccount().getUsername()).append(", ");
//		sb.append(getDevice().getName()).append(", ");
		sb.append(getYear()).append(", ");
		sb.append(getMonth()).append(", ");
		sb.append(getDayOfMonth()).append(", ");
		sb.append(getDayOfWeek()).append(", ");
		sb.append(getHour()).append(", ");
		sb.append(getMinute()).append(", ");
		sb.append(getLatitude()).append(", ");
		sb.append(getLongitude());

		return sb.toString();
	}
	
	public static void main(String[] args) {
		Device device = new DeviceImpl(new AccountImpl("jdoe@apple.com", "password"), "Chris iPhone");
		Location loc = new LocationImpl(device);
		loc.setLatitude(71.0212392929292);
		loc.setLongitude(131.4874635089344);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
//		c.set(Calendar.MONTH, 0);
		loc.setTimeStamp(c.getTimeInMillis());
		System.out.println("Day: " + loc.getDayOfMonth());
		System.out.println("Month: " + loc.getMonth());
		System.out.println("Minute: " + loc.getMinute());
		System.out.println("Hour: " + loc.getHour());
		System.out.println("Day of Week: " + loc.getDayOfWeek());
		System.out.println("DateTime String: " + loc.getDateTimeString());
		System.out.println("Location: " + loc);
	}
    
}
