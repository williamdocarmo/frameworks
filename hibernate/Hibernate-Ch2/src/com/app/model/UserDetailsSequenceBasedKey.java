package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS_SEQUENCE_KEY")
public class UserDetailsSequenceBasedKey {

	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "seq_hib", name = "hib_seq", initialValue = 0, allocationSize = 1)
	private int userId;

	private String username;

	public UserDetailsSequenceBasedKey(String username) {
		super();
		this.username = username;
	}

	public UserDetailsSequenceBasedKey() {
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
