package com.precognizant.jiphonetracker.model;

public interface Location {

	/**
	 * @return the device
	 */
	public Device getDevice();

	/**
	 * @return the timeStamp
	 */
	public long getTimeStamp();

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(long timeStamp);

	/**
	 * @return the locationType
	 */
	public String getLocationType();

	/**
	 * @param locationType the locationType to set
	 */
	public void setLocationType(String locationType);

	/**
	 * @return the positionType
	 */
	public String getPositionType();

	/**
	 * @param positionType the positionType to set
	 */
	public void setPositionType(String positionType);

	/**
	 * @return the horizontalAccuracy
	 */
	public float getHorizontalAccuracy();

	/**
	 * @param horizontalAccuracy the horizontalAccuracy to set
	 */
	public void setHorizontalAccuracy(float horizontalAccuracy);

	/**
	 * @return the locationFinished
	 */
	public boolean isLocationFinished();

	/**
	 * @param locationFinished the locationFinished to set
	 */
	public void setLocationFinished(boolean locationFinished);

	/**
	 * @return the isInaccurate
	 */
	public boolean isInaccurate();

	/**
	 * @param isInaccurate the isInaccurate to set
	 */
	public void setInaccurate(boolean isInaccurate);

	/**
	 * @return the longitude
	 */
	public double getLongitude();

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude);

	/**
	 * @return the latitude
	 */
	public double getLatitude();

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude);

	/**
	 * @return the isOld
	 */
	public boolean isOld();

	/**
	 * @param isOld the isOld to set
	 */
	public void setOld(boolean isOld);

	/**
	 * @return the month
	 */
	public int getMonth();

	/**
	 * @return the dayOfWeek
	 */
	public int getDayOfWeek();

	/**
	 * @return the dayOfMonth
	 */
	public int getDayOfMonth();

	/**
	 * @return the year
	 */
	public int getYear();

	/**
	 * @return the hour
	 */
	public int getHour();

	/**
	 * @return the minute
	 */
	public int getMinute();

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode();

	/**
	 * This is the overridden method to compare lat/lons.<br>
	 * WARNING: This breaks the contract with hashcode in that two locations can
	 * be equal AND have DIFFERENT hashcodes. This means that two location objects
	 * that are equal placed into a HashMap for instance, will result in two entries
	 * instead of one. There may be other erratic behavior as well.
	 * The reason for this is that there is an accuracy error in getting the location
	 * that results in devices looking like they are 'moving' between readings, even 
	 * when they are stationary. We calculate the disctance between two locations and
	 * factor out the horizontal accuracy discrepancy to determine if they are equal. 
	 * There isn't an easy way to pin the objects to the same hashcode though.
	 * 
	 * @param obj The other Location object to compare against
	 * @return true if the locations are located with a geo radius corresponding to the horizontal
	 * 			accuracy field of this object.
	 */
	public boolean equals(Object obj);

	public String getDateTimeString();

	/**
	 * Returns the location object as a String using comma separated values.
	 * 
	 * @return The location object as a comma separated value String.
	 */
	public String toString();

}