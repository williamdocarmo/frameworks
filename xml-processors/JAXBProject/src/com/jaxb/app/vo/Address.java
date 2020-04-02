package com.jaxb.app.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "AddressDetails")
@XmlAccessorType (XmlAccessType.FIELD)
public class Address {
	
	@XmlAttribute (name = "AddressType")
	private int addressType;
	@XmlElement (name = "StreetName", namespace = Employee.NS)
	private String streetName;
	@XmlElement (name = "City", namespace = Employee.NS)
	private String city;
	@XmlElement (name = "Pincode", namespace = Employee.NS)
	private String pincode;
	public int getAddressType() {
		return addressType;
	}
	public void setAddressType(int addressType) {
		this.addressType = addressType;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Address() {
		super();
	}
	public Address(int addressType, String streetName, String city, String pincode) {
		super();
		this.addressType = addressType;
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressType=" + addressType + ", streetName=" + streetName + ", city=" + city + ", pincode="
				+ pincode + "]";
	}

}
