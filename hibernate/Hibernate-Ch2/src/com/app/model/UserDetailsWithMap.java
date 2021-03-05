package com.app.model;

import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.vo.Address;

@Entity
@Table(name = "USER_DETAILS_MAP_OBJECT")
public class UserDetailsWithMap {
	
	public UserDetailsWithMap(String username, Map<String, Address> address) {
		super();
		this.username = username;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	private String username;

	@ElementCollection
	private Map<String, Address> address;

	public UserDetailsWithMap() {
		super();
		// TODO Auto-generated constructor stub
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

	public Map<String, Address> getAddress() {
		return address;
	}

	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDetailsWithList [userId=" + userId + ", username=" + username + ", addresses=" + address + "]";
	}

}
