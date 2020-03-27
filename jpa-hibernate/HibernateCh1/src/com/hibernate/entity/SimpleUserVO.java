package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SimpleUserVO {

	@Id
	private String userid;
	private String username;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "SimpleUserVO [userid=" + userid + ", username=" + username + "]";
	}

	public SimpleUserVO(String username) {
		super();
		this.username = username;
	}
	
	

}
