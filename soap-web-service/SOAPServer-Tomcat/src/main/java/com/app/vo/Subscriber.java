package com.app.vo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "SubscriberInformation")
@XmlType(propOrder = {"voice2G", "volte", "sms", "mms", "dataGprs"}, name = "SubscriberInformation")
public class Subscriber {

	@XmlAttribute(name = "MSISDN")
	private String msisdn;

	@XmlAttribute(name = "IMSI")
	private String imsi;

	@XmlElement(name = "VOICE_2G")
	private String voice2G;

	@XmlElement(name = "VOLTE", namespace = "newns")
	private String volte;

	@XmlElement(name = "SMS")
	private String sms;

	@XmlElement(name = "MMS")
	private String mms;

	@XmlElement(name = "GPRS")
	private String dataGprs;

	// @XmlElement(name = "LTE")
	@XmlTransient
	private String dataLte;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getVoice2G() {
		return voice2G;
	}

	public void setVoice2G(String voice2g) {
		voice2G = voice2g;
	}

	public String getVolte() {
		return volte;
	}

	public void setVolte(String volte) {
		this.volte = volte;
	}

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public String getMms() {
		return mms;
	}

	public void setMms(String mms) {
		this.mms = mms;
	}

	public String getDataGprs() {
		return dataGprs;
	}

	public void setDataGprs(String dataGprs) {
		this.dataGprs = dataGprs;
	}

	public String getDataLte() {
		return dataLte;
	}

	public void setDataLte(String dataLte) {
		this.dataLte = dataLte;
	}

	public Subscriber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscriber(String msisdn, String imsi, String voice2g, String volte, String sms, String mms, String dataGprs,
			String dataLte) {
		super();
		this.msisdn = msisdn;
		this.imsi = imsi;
		voice2G = voice2g;
		this.volte = volte;
		this.sms = sms;
		this.mms = mms;
		this.dataGprs = dataGprs;
		this.dataLte = dataLte;
	}

	@Override
	public String toString() {
		return "Subscriber [msisdn=" + msisdn + ", imsi=" + imsi + ", voice2G=" + voice2G + ", volte=" + volte
				+ ", sms=" + sms + ", mms=" + mms + ", dataGprs=" + dataGprs + ", dataLte=" + dataLte + "]";
	}

}