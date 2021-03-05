package com.app.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.vo.Address;

@Entity
@Table(name = "USER_DETAILS_COMPLEX_OVERRIDE")
public class UserDetailsComplexDataEmbeddedOverride {

	@Id
	@Column(name = "USER_ID", length = 3, nullable = false)
	@GeneratedValue
	private int id;

	@Column(name = "NAME")
	private String name;

	@Embedded
	private Address homeAddress;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name= "OFFICE_STREET_NAME")),
			@AttributeOverride(name = "city", column = @Column(name= "OFFICE_CITY")),
			@AttributeOverride(name = "state", column = @Column(name= "OFFICE_STATE")),
			@AttributeOverride(name = "pincode", column = @Column(name= "OFFICE_PIN_CODE"))
	})
	private Address officeAddress;

	@Column(name = "PHONE_NUMBER")
	private String phone;

	@Column(name = "DATE_OF_BIRTH")
	private Date dob;

	public UserDetailsComplexDataEmbeddedOverride() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetailsComplexDataEmbeddedOverride(String name, Address homeAddress, Address officeAddress, String phone,
			Date dob) {
		super();
		this.name = name;
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
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

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
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
		return "UserDetailsComplexDataMultipleEmbedded [id=" + id + ", name=" + name + ", homeAddress=" + homeAddress
				+ ", officeAddress=" + officeAddress + ", phone=" + phone + ", dob=" + dob + "]";
	}

}
