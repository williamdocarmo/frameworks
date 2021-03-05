package com.app.model;

import javax.persistence.Entity;

@Entity
public class Bike extends Vehicle {
	
	private String steeringHandle;

	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bike(String vehicleName) {
		super(vehicleName);
		// TODO Auto-generated constructor stub
	}

	public Bike(String vehicleName, String steeringHandle) {
		super(vehicleName);
		this.steeringHandle = steeringHandle;
	}

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
	@Override
	public String toString() {
		return "Bike [steeringHandle=" + steeringHandle + "]";
	}

}
