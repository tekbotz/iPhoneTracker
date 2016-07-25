/*
 * @(#)IPhoneLocationTestCase.java $Date: May 10, 2014 12:43:06 AM $
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
package com.precognizant.jiphonetracker.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.precognizant.jiphonetracker.controller.IPhoneTracker;

/**
 * Test Harness for unit testing the IPhoneTracker class.
 * 
 * @author Christopher Steel
 * @since May 10, 2014 12:43:06 AM
 */
public class IPhoneLocationTestCase {
	private static String username = null;
	private static String password = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		if(username == null || password == null) {
		byte[] buf = new byte[512];
		System.out.println("Please enter your iCloud account name (ex. jdoe@yahoo.com): ");
		int i = System.in.read(buf);
		if(i > 0) {
			username = new String(buf, "UTF-8").trim();
		}
		else 
			fail("No valid account name entered");
		buf = new byte[512];
		System.out.println("Please enter your iCloud account password (ex. Password1): ");
		i = System.in.read(buf);
		if(i > 0) {
			password = new String(buf, "UTF-8").trim();
		}
		else 
			fail("No valid password entered");
		}
	}

	/**
	 * Test method for {@link com.precognizant.jiphonetracker.util.IPhoneTracker#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		assertNotNull(IPhoneTracker.getInstance());
	}

	/**
	 * Test method for {@link com.precognizant.jiphonetracker.util.IPhoneTracker#getDevices()}.
	 * @throws Exception 
	 */
	@Test
	public void testSetCredentials() throws Exception {
		// Test negative case first
		IPhoneTracker instance = IPhoneTracker.getInstance();
		try {
			instance.addAccount("baduser", "badpassword");
			fail("Bad credentials did not cause exception.");
		}
		catch (SecurityException e) {
			assertTrue(true);
		}
		try {
			instance.addAccount(username, password);
			assertTrue(true);
		}
		catch (SecurityException e) {
			System.out.println(e);
			fail("Credentials entered failed to authorize. Please check account login information and try again.");
		}

	}

	/**
	 * Test method for {@link com.precognizant.jiphonetracker.util.IPhoneTracker#getDevices(org.json.simple.JSONObject)}.
	 */
	@Test
	public void testGetDevices() {
		try {
			IPhoneTracker instance = IPhoneTracker.getInstance();
			instance.addAccount(username, password);
			assertTrue(true);
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * Test method for {@link com.precognizant.jiphonetracker.util.IPhoneTracker#enableProxy()}.
	 */
	@Test
	public void testEnableProxy() {
		//fail("Not yet implemented");
	}

}
