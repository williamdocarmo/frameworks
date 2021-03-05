package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "USER_DETAILS_TABLE_KEY")
public class UserDetailsTableBasedKey {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "user_id_table", pkColumnName = "user_pk", valueColumnName = "next_val", allocationSize = 1, initialValue = 0)
	private int userId;

	private String username;

	public UserDetailsTableBasedKey(String username) {
		super();
		this.username = username;
	}

	public UserDetailsTableBasedKey() {
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
