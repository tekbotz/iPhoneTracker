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

/**
 * @author Christopher Steel - Software AG Government Solutions
 *
 * @since Jun 20, 2014 6:24:01 PM
 * @version 1.0
 */
public class UserInfoImpl implements UserInfo {
    private String firstName;
    private String lastName;
    private boolean hasMembers;
    private String membersInfo;
    
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.UserInfo#getFirstName()
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.UserInfo#setFirstName(java.lang.String)
	 */
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.UserInfo#getLastName()
	 */
	@Override
	public String getLastName() {
		return lastName;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.UserInfo#setLastName(java.lang.String)
	 */
	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.UserInfo#isHasMembers()
	 */
	@Override
	public boolean isHasMembers() {
		return hasMembers;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.UserInfo#setHasMembers(boolean)
	 */
	@Override
	public void setHasMembers(boolean hasMembers) {
		this.hasMembers = hasMembers;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.UserInfo#getMembersInfo()
	 */
	@Override
	public String getMembersInfo() {
		return membersInfo;
	}
	/* (non-Javadoc)
	 * @see com.precognizant.jiphonetracker.model.UserInfo#setMembersInfo(java.lang.String)
	 */
	@Override
	public void setMembersInfo(String membersInfo) {
		this.membersInfo = membersInfo;
	}
    
}
