package com.app.vo;

public class Subscriber {
	
	private String voiceGSM;
	
	private String voiceLTE;
	
	private String sms;
	
	private String mms;
	
	private String gprsData;
	
	private String lteData;

	public Subscriber() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subscriber(String voiceGSM, String voiceLTE, String sms, String mms, String gprsData, String lteData) {
		super();
		this.voiceGSM = voiceGSM;
		this.voiceLTE = voiceLTE;
		this.sms = sms;
		this.mms = mms;
		this.gprsData = gprsData;
		this.lteData = lteData;
	}

	public String getVoiceGSM() {
		return voiceGSM;
	}

	public void setVoiceGSM(String voiceGSM) {
		this.voiceGSM = voiceGSM;
	}

	public String getVoiceLTE() {
		return voiceLTE;
	}

	public void setVoiceLTE(String voiceLTE) {
		this.voiceLTE = voiceLTE;
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

	public String getGprsData() {
		return gprsData;
	}

	public void setGprsData(String gprsData) {
		this.gprsData = gprsData;
	}

	public String getLteData() {
		return lteData;
	}

	public void setLteData(String lteData) {
		this.lteData = lteData;
	}
	
}
