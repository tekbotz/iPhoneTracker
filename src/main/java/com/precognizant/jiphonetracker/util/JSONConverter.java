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

package com.precognizant.jiphonetracker.util;

import java.util.Iterator;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.precognizant.jiphonetracker.model.Account;
import com.precognizant.jiphonetracker.model.AccountImpl;
import com.precognizant.jiphonetracker.model.Device;
import com.precognizant.jiphonetracker.model.UserInfo;

/**
 * @author Christopher Steel - Software AG Government Solutions
 * 
 * @since Jun 20, 2014 4:22:33 PM
 * @version 1.0
 */
public class JSONConverter {
	protected static JSONParser jsonParser = new JSONParser();

	public static Vector<Device> getDevices(Account account, String jsonString) throws ParseException {
		JSONObject o = (JSONObject) jsonParser.parse(jsonString);
		
		JSONObject userInfoObj = (JSONObject) o.get("userInfo");
		UserInfo userInfo = (UserInfo) ProxyHandler.newInstance(UserInfo.class, userInfoObj);
		account.setUserInfo(userInfo);
		System.out.println("UserInfo: " + userInfo);
		
		Vector<Device> devices = new Vector<Device>();
		JSONArray content = (JSONArray) o.get("content");
		Iterator<?> i = content.iterator();
		while (i.hasNext()) {
			// Device device = new Device();
			JSONObject item = (JSONObject) i.next();
			Device device = (Device) ProxyHandler.newInstance(Device.class, item);
			System.out.println("Setting account: " + account);
			device.setAccount(account);
			//System.out.println("Device: " + device);
			//System.out.println("Device Model: " + device.getDeviceModel());
			//System.out.println("Location: " + device.getLocation());
			devices.add(device);
		}
		return devices;
	}

	public static void main(String[] args) {
		try {
			Account account = new AccountImpl("jdoe@gmail.com", "password");
			String json = "{\"statusCode\":\"200\",\"content\":[{\"canWipeAfterLock\":true,\"remoteWipe\":null,\"locFoundEnabled\":false,\"location\":{\"timeStamp\":1403321996290,\"locationType\":null,\"locationFinished\":true,\"horizontalAccuracy\":10.0,\"positionType\":\"GPS\",\"longitude\":-77.46749404825034,\"isInaccurate\":false,\"latitude\":39.03990852650166,\"isOld\":false},\"deviceModel\":\"FourthGen\",\"remoteLock\":null,\"activationLocked\":true,\"locationEnabled\":true,\"rawDeviceModel\":\"iPhone3,1\",\"modelDisplayName\":\"iPhone\",\"lostModeCapable\":true,\"id\":\"NOfWPvTinMJg2T/jcu/ZigRqCGoCvanPtsm2pPg148wgRifeQ7HnBOHYVNSUzmWV\",\"deviceDisplayName\":\"iPhone 4\",\"darkWake\":false,\"locationCapable\":true,\"maxMsgChar\":160,\"name\":\"Brandon?s iPhone\",\"batteryLevel\":0.0,\"features\":{\"CLT\":false,\"CWP\":false,\"WMG\":true,\"XRM\":false,\"CLK\":false,\"SND\":true,\"LST\":true,\"KEY\":false,\"WIP\":true,\"LOC\":true,\"LLC\":false,\"MSG\":true,\"LMG\":false,\"LCK\":true,\"REM\":false,\"SVP\":false,\"TEU\":true,\"LKL\":true,\"LKM\":false,\"PIN\":false,\"KPD\":false},\"deviceClass\":\"iPhone\",\"wipeInProgress\":false,\"passcodeLength\":4,\"mesg\":null,\"isMac\":false,\"snd\":null,\"isLocating\":true,\"trackingInfo\":null,\"deviceColor\":null,\"batteryStatus\":\"Unknown\",\"deviceStatus\":\"203\",\"wipedTimestamp\":null,\"lockedTimestamp\":null,\"msg\":null,\"lostTimestamp\":\"\",\"lostModeEnabled\":false,\"thisDevice\":false,\"lostDevice\":null,\"prsId\":null}],\"userInfo\":{\"lastName\":\"Steel\",\"hasMembers\":false,\"membersInfo\":null,\"firstName\":\"Brandon\"},\"userPreferences\":null,\"serverContext\":{\"minTrackLocThresholdInMts\":100,\"prefsUpdateTime\":0,\"maxDeviceLoadTime\":60000,\"authToken\":\"AQAAAABTpJpQkkw4pEdsMzp8-SDKUPErDOz5ZpM~\",\"classicUser\":false,\"sessionLifespan\":900000,\"serverTimestamp\":1403296336646,\"enableMapStats\":true,\"imageBaseUrl\":\"https://statici.icloud.com\",\"deviceLoadStatus\":\"200\",\"preferredLanguage\":\"en-us\",\"clientId\":\"ZGV2aWNlXzM2MTQ5MTMxM18xNDAzMjk2MzM2NjQy\",\"lastSessionExtensionTime\":null,\"trackInfoCacheDurationInSecs\":86400,\"isHSA\":false,\"timezone\":{\"tzCurrentName\":\"Eastern Daylight Time\",\"previousTransition\":1394348399999,\"previousOffset\":-18000000,\"currentOffset\":-14400000,\"tzName\":\"America/New_York\"},\"callbackIntervalInMS\":2000,\"cloudUser\":true,\"validRegion\":true,\"maxLocatingTime\":90000,\"prsId\":361491313,\"macCount\":0}}";
			JSONConverter.getDevices(account, json);
		} catch (Exception e) {
			System.out.println("Caught exception: " + e);
			e.printStackTrace();
		}
	}

}
