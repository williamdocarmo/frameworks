package com.soap.service.address;

import javax.xml.bind.annotation.XmlElement;

public class AddressType {
	
	@XmlElement(name="Address")
	private String Address;

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	

}
