package com.app.vo;

public class AuthenticationData {
	
	String username;
	
	String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationData() {
		super();
	}

	public AuthenticationData(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthenticationData [username=" + username + ", password=" + password + "]";
	}
	
}
