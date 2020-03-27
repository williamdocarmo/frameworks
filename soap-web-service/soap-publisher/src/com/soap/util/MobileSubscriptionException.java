package com.soap.util;

import javax.xml.ws.WebFault;

@WebFault(name="MobileException")
public class MobileSubscriptionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int errorCode;
	private String errorMessage;

	public MobileSubscriptionException(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
