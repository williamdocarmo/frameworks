package com.soap.util;

public class SecurityException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public SecurityException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	

}
