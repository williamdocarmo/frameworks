package com.soap.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="UserData")
public class SubscriberData {

	private String customerId;
	private String msisdn;
	private String offer;
	private int billCycle;
	private Date connectionStartDate;
	private boolean isPostpaid;
	private boolean voicemailServer;

	@XmlAttribute(name="customer")
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@XmlElement(name="phoneNumber")
	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public int getBillCycle() {
		return billCycle;
	}

	public void setBillCycle(int billCycle) {
		this.billCycle = billCycle;
	}

	public Date getConnectionStartDate() {
		return connectionStartDate;
	}

	public void setConnectionStartDate(Date connectionStartDate) {
		this.connectionStartDate = connectionStartDate;
	}

	public boolean isPostpaid() {
		return isPostpaid;
	}

	public void setPostpaid(boolean isPostpaid) {
		this.isPostpaid = isPostpaid;
	}

	@XmlTransient
	public boolean isVoicemailServer() {
		return voicemailServer;
	}

	public void setVoicemailServer(boolean voicemailServer) {
		this.voicemailServer = voicemailServer;
	}

	public SubscriberData(String msisdn, String offer, int billCycle, Date connectionStartDate, boolean isPostpaid) {
		super();
		this.msisdn = msisdn;
		this.offer = offer;
		this.billCycle = billCycle;
		this.connectionStartDate = connectionStartDate;
		this.isPostpaid = isPostpaid;
	}

	public SubscriberData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SubscriberData [msisdn=" + msisdn + ", offer=" + offer + ", billCycle=" + billCycle
				+ ", connectionStartDate=" + connectionStartDate + ", isPostpaid=" + isPostpaid + "]";
	}

}
