/*
 * @(#)LocationUpdateListener.java $Date: May 10, 2014 12:31:49 AM $
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
 * Listener interface for LocationUpdateEvents. Listeners will receive location
 * update events by implementing this interface and registering with the 
 * IPhoneTracker.
 * 
 * @author Christopher Steel
 * @since May 10, 2014 12:31:49 AM
 */
public interface LocationUpdateListener {
	public void update(LocationEvent event);

}
