package com.precognizant.jiphonetracker.model;

public interface UserInfo {

	/**
	 * @return the firstName
	 */
	public String getFirstName();

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName);

	/**
	 * @return the lastName
	 */
	public String getLastName();

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName);

	/**
	 * @return the hasMembers
	 */
	public boolean isHasMembers();

	/**
	 * @param hasMembers the hasMembers to set
	 */
	public void setHasMembers(boolean hasMembers);

	/**
	 * @return the membersInfo
	 */
	public String getMembersInfo();

	/**
	 * @param membersInfo the membersInfo to set
	 */
	public void setMembersInfo(String membersInfo);

}