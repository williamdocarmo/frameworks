package com.app.vo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CustomerInformation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
	
	@XmlElement(name = "Customer_ID")
	private String customerId;
	
	@XmlElement(name = "Customer_Name")
	private String customerName;
	
	@XmlElement(name = "Customer_Addr")
	private String customeAddress;
	
	public Customer() {
		super();
	}

	public Customer(String customerId, String customerName, String customeAddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customeAddress = customeAddress;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomeAddress() {
		return customeAddress;
	}

	public void setCustomeAddress(String customeAddress) {
		this.customeAddress = customeAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customeAddress="
				+ customeAddress + "]";
	}
	
}
