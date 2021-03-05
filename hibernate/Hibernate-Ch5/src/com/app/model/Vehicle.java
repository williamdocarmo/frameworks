package com.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int vehicleId;

	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "vehicles")
	// @JoinTable(name = "VEHICLE_USER", joinColumns = @JoinColumn(name = "VEHICLE_ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID"))
	private List<UserDetails> userList;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Vehicle(String vehicleName, UserDetails user) {
		super();
		this.vehicleName = vehicleName;
		addUser(user);
	}

	public Vehicle() {
		super();
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", userList=" + userList + "]";
	}

	public List<UserDetails> getUserList() {
		return userList;
	}

	public void addUser(UserDetails user) {
		if (null == userList) {
			userList = new ArrayList<UserDetails>();
		}
		userList.add(user);
	}

}
