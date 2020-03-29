package com.app.validator;

public class SubscriberData {
	
	@Validator(nullcheck=true, startsWith="41902")
	private String imsi;
	@Validator(nullcheck= true, startsWith="965")
	private String isdn;
	@Validator(minLength=1, maxLength=4, startsWith="bs")
	private String bsg;
	@Validator(minVal=1, maxVal= 255, nullcheck=true)
	private int hlrsn;
	@Validator(allowedValues={"0", "1", "TRUE", "FALSE"})
	private String tcsiprov;
	@Validator(nullcheck=true)
	private String ocsiprov;
	@Validator(regex="^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$")
	private String ipv4Address;

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getIsdn() {
		return isdn;
	}

	public void setIsdn(String isdn) {
		this.isdn = isdn;
	}

	public String getBsg() {
		return bsg;
	}

	public void setBsg(String bsg) {
		this.bsg = bsg;
	}
	

	public int getHlrsn() {
		return hlrsn;
	}

	public void setHlrsn(int hlrsn) {
		this.hlrsn = hlrsn;
	}
	

	public String getTcsiprov() {
		return tcsiprov;
	}

	public void setTcsiprov(String tcsiprov) {
		this.tcsiprov = tcsiprov;
	}
	

	public String getOcsiprov() {
		return ocsiprov;
	}

	public void setOcsiprov(String ocsiprov) {
		this.ocsiprov = ocsiprov;
	}

	public String getIpv4Address() {
		return ipv4Address;
	}

	public void setIpv4Address(String ipv4Address) {
		this.ipv4Address = ipv4Address;
	}
	
	public SubscriberData(String imsi, String isdn, String bsg, int hlrsn, String tcsiprov, String ocsiprov,
			String ipv4Address) {
		super();
		this.imsi = imsi;
		this.isdn = isdn;
		this.bsg = bsg;
		this.hlrsn = hlrsn;
		this.tcsiprov = tcsiprov;
		this.ocsiprov = ocsiprov;
		this.ipv4Address = ipv4Address;
	}

	@Override
	public String toString() {
		return "DEABOIC [imsi=" + imsi + ", isdn=" + isdn + ", bsg=" + bsg + ", hlrsn=" + hlrsn + ", tcsiprov="
				+ tcsiprov + ", ocsiprov=" + ocsiprov + ", ipAddress=" + ipv4Address + "]";
	}
}
