package com.app.ws.springbootsoapws.service;

import org.springframework.stereotype.Service;

import com.ericsson.mdc.ws.soap.ResponseHeader;
import com.ericsson.mdc.ws.soap.UserAuthenticationData;
import com.ericsson.mdc.ws.soap.UserAuthenticationRequest;
import com.ericsson.mdc.ws.soap.UserAuthenticationResponse;

@Service
public class MDCServiceLogic {

	public UserAuthenticationResponse authenticateUser(UserAuthenticationRequest authenticationRequest) {
		UserAuthenticationResponse response = new UserAuthenticationResponse();
		ResponseHeader header = new ResponseHeader();
		UserAuthenticationData authenticationData = new UserAuthenticationData();
		header.setResponseTime("30ms");
		header.setSource("HARD_CODED");
		header.setStatusCode("SUCCESS");
		header.setStatusMessage("User Authenticated Successfully");
		
		authenticationData.setSignum("Santanu");
		authenticationData.setPassword("My Password");
		authenticationData.setRole("Admin");
		
		response.setResponseHeader(header);
		response.setUserAuthenticationData(authenticationData);
		return response;
	}

}
