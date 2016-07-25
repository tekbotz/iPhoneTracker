/*
 * @(#)LocationListenerManager.java $Date: May 10, 2014 3:23:29 PM $
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

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import com.precognizant.jiphonetracker.model.LocationEvent.EVENT_TYPE;


/**
 * @author Christopher Steel
 *
 * @since May 10, 2014 3:23:29 PM
 */
public class LocationListenerManager {
	
	private Map<String, Vector<LocationUpdateListener>> deviceListeners = 
			new ConcurrentHashMap<String, Vector<LocationUpdateListener>>();
	private Vector<LocationUpdateListener> allListeners =
			new Vector<LocationUpdateListener>();
	
	public void notifyListeners(LocationEvent event) {
		if(null == deviceListeners.get(event.getDeviceName())) {
			throw new UnsupportedOperationException("Device not found: " + event.getDeviceName());
		}
		Vector<LocationUpdateListener> listeners = this.deviceListeners.get(event.getDeviceName());
		notifyListeners(listeners, event);
	}
	
	public void register(String device, LocationUpdateListener listener) {
		if(this.allListeners.contains(listener)) {
			throw new UnsupportedOperationException("Already registered through all device registration");
		}
		if(!this.deviceListeners.containsKey(device))
			throw new UnsupportedOperationException("Device not registered");
		if(this.deviceListeners.get(device).contains(listener)) {
			throw new UnsupportedOperationException("Already registered for device: " + device);
		}
		deviceListeners.get(device).add(listener);
	}

	public void register(LocationUpdateListener listener) {
		allListeners.add(listener);
	}

	public void deregister(LocationUpdateListener listener) {
		if(!this.allListeners.contains(listener))
			throw new UnsupportedOperationException("Not registered");
		allListeners.remove(listener);
	}
	
	public void deregister(String device, LocationUpdateListener listener) {
		if(!this.deviceListeners.containsKey(device))
			throw new UnsupportedOperationException("Device not registered");
		Vector<LocationUpdateListener> listeners = this.deviceListeners.get(device);
		if(!listeners.contains(listener))
			throw new UnsupportedOperationException("Listener not registered");
		listeners.remove(listener);
	}

	public Set<String> getRegisteredDevices() {
		return this.deviceListeners.keySet();
	}
	
	protected void registerDevice(String device) {
		if(this.deviceListeners.containsKey(device))
			throw new UnsupportedOperationException("Device already registered");
		this.deviceListeners.put(device, new Vector<LocationUpdateListener>());
	}
	
	public void deregister(String device) {
		if(!this.deviceListeners.containsKey(device))
			throw new UnsupportedOperationException("Device not registered");
		Vector<LocationUpdateListener> listeners = this.deviceListeners.remove(device);
		notifyListeners(listeners, new LocationEvent(device, LocationEvent.EVENT_TYPE.DEVICE_DEREGISTERED));
	}

	private void notifyListeners(Vector<LocationUpdateListener> listeners, LocationEvent event) {
		Iterator<LocationUpdateListener> it = allListeners.iterator();
		while(it.hasNext()) {
			LocationUpdateListener listener = (LocationUpdateListener) it.next();
			listener.update(event);
		}
		it = listeners.iterator();
		while(it.hasNext()) {
			LocationUpdateListener listener = (LocationUpdateListener) it.next();
			listener.update(event);
		}
	}
	
	public static void main(String[] args) {
		LocationListenerManager mgr = new LocationListenerManager();
		LocationUpdateListener l1 = new UpdateListener("Listener 1");
		LocationUpdateListener l2 = new UpdateListener("Listener 2");
		LocationUpdateListener l3 = new UpdateListener("Listener 3");
		mgr.registerDevice("iPhone 1");
		mgr.registerDevice("iPhone 2");
		mgr.registerDevice("iPhone 3");
		System.out.println("Devices: " + mgr.getRegisteredDevices());
		mgr.register("iPhone 1", l1);
		mgr.register("iPhone 2", l2);
		mgr.register(l3);
		LocationEvent e1 = new LocationEvent("iPhone 1", EVENT_TYPE.LOCATION_UPDATE);
		LocationEvent e2 = new LocationEvent("iPhone 2", EVENT_TYPE.LOCATION_UPDATE);
		mgr.notifyListeners(e1);
		mgr.notifyListeners(e2);
		mgr.deregister("iPhone 2", l2);
		mgr.notifyListeners(e1);
		mgr.notifyListeners(e2);
		mgr.deregister("iPhone 1");
//		mgr.notifyListeners(e1);
//		mgr.notifyListeners(e2);
	}
	
}
class UpdateListener implements LocationUpdateListener {
	private String name;
	public UpdateListener(String name) {
		this.name = name;
	}
	@Override
	public void update(LocationEvent event) {
		System.out.println("Notify called " + name + " for device " + event.getDeviceName() + " event type: " + event.getEventType());
	}
	
}