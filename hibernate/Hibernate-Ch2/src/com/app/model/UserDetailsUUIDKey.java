package com.app.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_UUID_KEY")
public class UserDetailsUUIDKey {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private UUID userId;

	private String username;

	public UserDetailsUUIDKey(String username) {
		super();
		this.username = username;
	}

	public UserDetailsUUIDKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
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
