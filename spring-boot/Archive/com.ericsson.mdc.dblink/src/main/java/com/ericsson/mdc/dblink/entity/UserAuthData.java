package com.ericsson.mdc.dblink.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMDC_USER_AUTH_DATA")
public class UserAuthData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="SIGNUM", length=7, nullable=false, unique=true, updatable=false, insertable=true)
	private String signum;
	@Column(name="PASSWORD", insertable=true, nullable=false, unique=false, updatable=true)
	private String password;
	@Column(name="ROLE", insertable=true, nullable=false, unique=false, updatable=true)
	private String role;
	public String getSignum() {
		return signum;
	}
	public void setSignum(String signum) {
		this.signum = signum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserAuthData(String signum, String password, String role) {
		super();
		this.signum = signum;
		this.password = password;
		this.role = role;
	}
	public UserAuthData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserAuthenticationData [signum=" + signum + ", password=" + password + ", role=" + role + "]";
	}
	

}
