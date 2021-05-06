package com.app.model.vo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class SubscriberIdentifier implements Serializable {
	
	private String phoneNumber;
	
	private String emailId;

	public SubscriberIdentifier() {
		super();
	}

	public SubscriberIdentifier(String phoneNumber, String emailId) {
		super();
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "SubscriberIdentifier [phoneNumber=" + phoneNumber + ", emailId=" + emailId + "]";
	}
	
}
