package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.app.util.BooleanToStringConverter;

@Entity
@Table(name = "MOBILE_SUBSCRIBER")
public class Subscriber {

	public Subscriber() {
		super();
	}

	public Subscriber(int subscriberID, String msisdn, Date firstBilling, String address, String description,
			boolean lteSubscription) {
		super();
		this.subscriberID = subscriberID;
		this.msisdn = msisdn;
		this.firstBilling = firstBilling;
		this.address = address;
		this.description = description;
		this.lteSubscription = lteSubscription;
	}

	@Id
	@Column(name = "SUBSCRIBER_ID")
	private int subscriberID;

	@Column(name = "MSISDN")
	private String msisdn;

	@Temporal(TemporalType.DATE)
	@Column(name = "BILLING_STARTED")
	private Date firstBilling;

	@Column(name = "CUSTOMER_ADDRESS")
	@Transient
	private String address;

	@Lob
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "LTE_SUBSCRIPTION")
	@Convert(converter = BooleanToStringConverter.class)
	private boolean lteSubscription;

	public int getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(int subscriberID) {
		this.subscriberID = subscriberID;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Date getFirstBilling() {
		return firstBilling;
	}

	public void setFirstBilling(Date firstBilling) {
		this.firstBilling = firstBilling;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getLteSubscription() {
		return lteSubscription;
	}

	public void setLteSubscription(boolean lteSubscription) {
		this.lteSubscription = lteSubscription;
	}

	@Override
	public String toString() {
		return "Subscriber [subscriberID=" + subscriberID + ", msisdn=" + msisdn + ", firstBilling=" + firstBilling
				+ ", address=" + address + ", description=" + description + ", lteSubscription=" + lteSubscription
				+ "]";
	}

}
