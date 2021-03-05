package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_SIMPLE_INTEGER_KEY")
public class UserDetailsSimpleKey {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int userId;

	private String username;

	public UserDetailsSimpleKey(String username) {
		super();
		this.username = username;
	}

	public UserDetailsSimpleKey() {
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

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", username=" + username + "]";
	}

}
