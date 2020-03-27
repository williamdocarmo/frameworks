package com.soap.vo;

public class SecurityDetails {
	
	private String username;
	private String password;

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

	public SecurityDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SecurityDetails(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "SecurityDetails [username=" + username + ", password=" + password + "]";
	}

}
