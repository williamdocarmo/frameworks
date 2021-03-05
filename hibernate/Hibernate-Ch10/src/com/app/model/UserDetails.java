package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@SelectBeforeUpdate
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where id = :id")
@NamedQuery(name = "UserDetails.getAll", query = "from UserDetails")
@NamedNativeQuery (name = "UserDetails.byIdNative", query = "select * from UserDetails where id = :id", resultClass = UserDetails.class)
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;
	
	public UserDetails() {
		super();
	}
	
	

	public UserDetails(String username) {
		super();
		this.username = username;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", username=" + username + "]";
	}
	
	

}
