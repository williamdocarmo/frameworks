package com.app.ws.springbootsoapws.utils;

public class UnauthorizedAccessException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private int errorCode;
	
	private String errorMessage;
	
	public UnauthorizedAccessException() {
		super();
	}
	
	public UnauthorizedAccessException(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getFaultInfo() {
		return this.errorMessage;
	}
	
	public int getFaultCode() {
		return this.errorCode;
	}

}
