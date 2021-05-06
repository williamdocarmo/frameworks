package com.app.exc;

public class InvalidUsernameException extends Exception {
	
	private static final long serialVersionUID = -2290697210697455769L;

	private String errorDetails;
	
	private int errorCode;
	
	public InvalidUsernameException(int errorCode, String reason, String errorDetails) {
		super(reason);
		this.errorDetails = errorDetails;
		this.errorCode = errorCode;
	}
	
	public String getFaultInfo() {
		return this.errorDetails;
	}
	
	public int getFaultCode() {
		return this.errorCode;
	}

}
