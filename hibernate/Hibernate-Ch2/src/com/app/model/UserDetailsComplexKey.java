package com.app.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.vo.SubscriberIdentifier;

@Entity
@Table(name = "USER_DETAILS_COMPLEX_KEY")
public class UserDetailsComplexKey {

	@EmbeddedId
	private SubscriberIdentifier userId;

	private String username;

	public UserDetailsComplexKey(SubscriberIdentifier userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

	public UserDetailsComplexKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubscriberIdentifier getUserId() {
		return userId;
	}

	public void setUserId(SubscriberIdentifier userId) {
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
