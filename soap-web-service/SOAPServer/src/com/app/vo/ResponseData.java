package com.app.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseData {
	
	private int statusCode;
	
	private String statusMessage;

	public ResponseData() {
		super();
	}

	public ResponseData(int statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "ResponseData [statusCode=" + statusCode + ", statusMessage=" + statusMessage + "]";
	}
	
}
