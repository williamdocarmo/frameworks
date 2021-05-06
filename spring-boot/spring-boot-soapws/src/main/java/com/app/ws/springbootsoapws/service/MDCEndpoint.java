package com.app.ws.springbootsoapws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.app.ws.springbootsoapws.utils.SoapServiceConstants;
import com.ericsson.mdc.ws.soap.UserAuthenticationRequest;
import com.ericsson.mdc.ws.soap.UserAuthenticationResponse;

@Endpoint
public class MDCEndpoint {
	
	private static final Logger logger = LoggerFactory.getLogger(MDCEndpoint.class);

	@Autowired
	private MDCServiceLogic serviceLogic;
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_USER_AUTHENTICATION)
	@ResponsePayload
	public UserAuthenticationResponse authenticateUser(@RequestPayload UserAuthenticationRequest authenticationRequest){
		logger.info("Request Source: "+authenticationRequest.getRequestHeader().getSourceSystem());
		logger.info("Request Timestamp: "+authenticationRequest.getRequestHeader().getTimestamp());
		logger.info("Request User: "+authenticationRequest.getSignum());
		return serviceLogic.authenticateUser(authenticationRequest);
	}
	
}