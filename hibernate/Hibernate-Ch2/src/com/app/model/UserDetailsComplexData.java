package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.vo.Address;

@Entity
@Table(name = "USER_DETAILS_COMPLEX")
public class UserDetailsComplexData {

	@Id
	@Column(name = "USER_ID", length = 3, nullable = false)
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private String name;
	
	@Embedded
	private Address address;
	
	@Column(name = "PHONE_NUMBER")
	private String phone;
	
	@Column(name = "DATE_OF_BIRTH")
	private Date dob;

	public UserDetailsComplexData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetailsComplexData(String name, Address address, String phone, Date dob) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "UserDetailsComplexData [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", dob=" + dob + "]";
	}

}
