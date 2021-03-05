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
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String username;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	private List<Vehicle> vehicles;

	public UserDetails(String username) {
		super();
		this.username = username;
	}

	public UserDetails() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void addVehicle(Vehicle vehicle) {
		if (null == vehicles) {
			vehicles = new ArrayList<Vehicle>();
		}
		vehicles.add(vehicle);
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", username=" + username + "]";
	}

}
