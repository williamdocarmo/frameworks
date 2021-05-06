package com.ericsson.mdc.dblink.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ericsson.mdc.dblink.constants.SoapServiceConstants;
import com.ericsson.mdc.dblink.service.MDCServiceLogic;
import com.ericsson.mdc.ws.soap.ChangePasswordRequest;
import com.ericsson.mdc.ws.soap.ChangePasswordResponse;
import com.ericsson.mdc.ws.soap.GetAllActivityRequest;
import com.ericsson.mdc.ws.soap.GetBasicResourceDetailsRequest;
import com.ericsson.mdc.ws.soap.GetBasicResourceDetailsResponse;
import com.ericsson.mdc.ws.soap.GetCurrentActivityRequest;
import com.ericsson.mdc.ws.soap.GetCurrentActivityResponse;
import com.ericsson.mdc.ws.soap.GetDetailedResourceDetailsByManagerRequest;
import com.ericsson.mdc.ws.soap.GetDetailedResourceDetailsByManagerResponse;
import com.ericsson.mdc.ws.soap.GetDetailedResourceDetailsRequest;
import com.ericsson.mdc.ws.soap.GetDetailedResourceDetailsResponse;
import com.ericsson.mdc.ws.soap.GetResourcesByManagerRequest;
import com.ericsson.mdc.ws.soap.GetResourcesByManagerResponse;
import com.ericsson.mdc.ws.soap.GetResourcesByRoleRequest;
import com.ericsson.mdc.ws.soap.GetResourcesByRoleResponse;
import com.ericsson.mdc.ws.soap.UpdateBasicResourceDetailsRequest;
import com.ericsson.mdc.ws.soap.UpdateBasicResourceDetailsResponse;
import com.ericsson.mdc.ws.soap.UpdateCurrentActivityRequest;
import com.ericsson.mdc.ws.soap.UpdateCurrentActivityResponse;
import com.ericsson.mdc.ws.soap.UpdateDetailedResourceDetailsRequest;
import com.ericsson.mdc.ws.soap.UpdateDetailedResourceDetailsResponse;
import com.ericsson.mdc.ws.soap.UserAuthenticationRequest;
import com.ericsson.mdc.ws.soap.UserAuthenticationResponse;
import com.ericsson.mdc.ws.soap.UserRegistrationRequest;
import com.ericsson.mdc.ws.soap.UserRegistrationResponse;

@Endpoint
public class MDCEndpoint {

	@Autowired
	private MDCServiceLogic serviceLogic;
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_USER_AUTHENTICATION)
	@ResponsePayload
	public UserAuthenticationResponse authenticateUser(@RequestPayload UserAuthenticationRequest authenticationRequest){
		return serviceLogic.authenticateUser(authenticationRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_USER_REGISTRATION)
	@ResponsePayload
	public UserRegistrationResponse Milestone(@RequestPayload UserRegistrationRequest registrationRequest){
		return serviceLogic.registerUser(registrationRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_CHANGE_PASSWORD)
	@ResponsePayload
	public ChangePasswordResponse changePassword(@RequestPayload ChangePasswordRequest changePasswordRequest){
		return serviceLogic.changePassword(changePasswordRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_GET_BASIC_RESOURCE)
	@ResponsePayload
	public GetBasicResourceDetailsResponse getBasicResourceDetails(@RequestPayload GetBasicResourceDetailsRequest getBasicResourceDetailsRequest){
		return serviceLogic.getBasicResourceDetails(getBasicResourceDetailsRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_UPDATE_BASIC_RESOURCE)
	@ResponsePayload
	public UpdateBasicResourceDetailsResponse updateBasicResourceDetails(@RequestPayload UpdateBasicResourceDetailsRequest updateBasicResourceDetailsRequest){
		return serviceLogic.updateBasicResourceDetails(updateBasicResourceDetailsRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_UPDATE_CURRENT_ACTIVITY)
	@ResponsePayload
	public UpdateCurrentActivityResponse updateCurrentActivityDetails(@RequestPayload UpdateCurrentActivityRequest updateCurrentActivityRequest){
		return serviceLogic.updateCurrentActivityDetails(updateCurrentActivityRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_GET_CURRENT_ACTIVITY)
	@ResponsePayload
	public GetCurrentActivityResponse getCurrentActivityDetails(@RequestPayload GetCurrentActivityRequest getCurrentActivityRequest){
		return serviceLogic.getCurrentActivityDetails(getCurrentActivityRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_GET_ALL_ACTIVITY)
	@ResponsePayload
	public GetCurrentActivityResponse getAllActivityDetails(@RequestPayload GetAllActivityRequest getAllActivityRequest){
		return serviceLogic.getAllActivityDetails();
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_GET_DETAILED_RESOURCE)
	@ResponsePayload
	public GetDetailedResourceDetailsResponse getDetailedResourceDetails(@RequestPayload GetDetailedResourceDetailsRequest getDetailedResourceDetailsRequest){
		return serviceLogic.getDetailedResourceDetails(getDetailedResourceDetailsRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_UPDATE_DETAILED_RESOURCE)
	@ResponsePayload
	public UpdateDetailedResourceDetailsResponse updateDetailedResourceDetails(@RequestPayload UpdateDetailedResourceDetailsRequest updateDetailedResourceDetailsRequest){
		return serviceLogic.updateDetailedResourceDetails(updateDetailedResourceDetailsRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_GET_DETAILED_RESOURCE_MANAGER)
	@ResponsePayload
	public GetDetailedResourceDetailsByManagerResponse getDetailedResourceDetailsByManager(@RequestPayload GetDetailedResourceDetailsByManagerRequest getDetailedResourceDetailsByManagerRequest){
		return serviceLogic.getDetailedResourceDetailsByManager(getDetailedResourceDetailsByManagerRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_GET_RESOURCE_BY_ROLE)
	@ResponsePayload
	public GetResourcesByRoleResponse getResourcesByRole(@RequestPayload GetResourcesByRoleRequest getResourceByRoleRequest){
		return serviceLogic.getResourceByRole(getResourceByRoleRequest);
	}
	
	@PayloadRoot(namespace = SoapServiceConstants.NAMESPACE_URI, localPart = SoapServiceConstants.LOCAL_PART_RESOURCES_BY_MANAGER)
	@ResponsePayload
	public GetResourcesByManagerResponse getResourcesByManager(@RequestPayload GetResourcesByManagerRequest request){
		return serviceLogic.getResourcesByManager(request);
	}
	
}