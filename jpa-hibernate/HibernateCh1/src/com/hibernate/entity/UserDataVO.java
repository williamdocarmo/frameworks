package com.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "USER_DETAILS")
@Table(name = "USER_DETAILS")
public class UserDataVO implements Serializable {

	@Id
	@Column(name = "USER_ID", length = 8, insertable = true, updatable = true, nullable = false)
	private String userId;

	@Basic(fetch=FetchType.EAGER)
	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "DOB")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;

	@Column(name = "BIOGRAPHY")
	@Lob
	private String biography;
	
	@Transient
	private String secretInfo;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getSecretInfo() {
		return secretInfo;
	}

	public void setSecretInfo(String secretInfo) {
		this.secretInfo = secretInfo;
	}

	@Override
	public String toString() {
		return "UserDataVO [userId=" + userId + ", username=" + username + ", dateOfBirth=" + dateOfBirth
				+ ", biography=" + biography + "]";
	}

}
