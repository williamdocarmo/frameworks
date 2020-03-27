package com.hibernate.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table (name="USERDETAILS")
public class UserDataVO {

	@Id
	private String username;
	private String firstname;
	private String lastname;
	private Date dateOfBirth;
	private int age;
	@Lob
	private String biography;
	private boolean oldUser;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	public boolean getOldUser() {
		return oldUser;
	}

	public void setOldUser(boolean oldUser) {
		this.oldUser = oldUser;
	}


	@Override
	public String toString() {
		return "UserDataVO [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", biography=" + biography + "]";
	}

}
