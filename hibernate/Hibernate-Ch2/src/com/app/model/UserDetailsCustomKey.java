package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "USER_DETAILS_CUSTOM_KEY")
public class UserDetailsCustomKey {

	@Id
	@GeneratedValue(generator = "custom-generator")
	@GenericGenerator(name = "custom-generator", strategy = "com.app.util.CustomIDGenerator")
	private String userId;

	private String username;

	public UserDetailsCustomKey(String username) {
		super();
		this.username = username;
	}

	public UserDetailsCustomKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", username=" + username + "]";
	}

}
