package com.app.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FourWheelerVehicle")
public class Car extends Vehicle {

	private String steeringWheel;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String vehicleName) {
		super(vehicleName);
		// TODO Auto-generated constructor stub
	}

	public Car(String vehicleName, String steeringWheel) {
		super(vehicleName);
		this.steeringWheel = steeringWheel;
	}

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}

	@Override
	public String toString() {
		return "Car [steeringWheel=" + steeringWheel + "]";
	}

}
