package com.ericsson.mdc.dblink.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.mdc.dblink.constants.StatusCodes.STATUS;
import com.ericsson.mdc.dblink.entity.ResourceBasicInfo;
import com.ericsson.mdc.dblink.entity.ResourceCurrentActivity;
import com.ericsson.mdc.dblink.entity.ResourceDetailedInformation;
import com.ericsson.mdc.dblink.entity.UserAuthData;
import com.ericsson.mdc.dblink.services.orm.MdcService;
import com.ericsson.mdc.dblink.utils.CommonUtils;
import com.ericsson.mdc.ws.soap.BasicResourceDetails;
import com.ericsson.mdc.ws.soap.ChangePasswordRequest;
import com.ericsson.mdc.ws.soap.ChangePasswordResponse;
import com.ericsson.mdc.ws.soap.CurrentActivityDetails;
import com.ericsson.mdc.ws.soap.DetailedResourceDetails;
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
import com.ericsson.mdc.ws.soap.ResponseHeader;
import com.ericsson.mdc.ws.soap.UpdateBasicResourceDetailsRequest;
import com.ericsson.mdc.ws.soap.UpdateBasicResourceDetailsResponse;
import com.ericsson.mdc.ws.soap.UpdateCurrentActivityRequest;
import com.ericsson.mdc.ws.soap.UpdateCurrentActivityResponse;
import com.ericsson.mdc.ws.soap.UpdateDetailedResourceDetailsRequest;
import com.ericsson.mdc.ws.soap.UpdateDetailedResourceDetailsResponse;
import com.ericsson.mdc.ws.soap.UserAuthenticationData;
import com.ericsson.mdc.ws.soap.UserAuthenticationRequest;
import com.ericsson.mdc.ws.soap.UserAuthenticationResponse;
import com.ericsson.mdc.ws.soap.UserRegistrationRequest;
import com.ericsson.mdc.ws.soap.UserRegistrationResponse;

@Component
public class MDCServiceLogic {

	@Autowired
	private MdcService dataService;

	// Done
	public UserAuthenticationResponse authenticateUser(UserAuthenticationRequest authenticationRequest) {
		String signum = authenticationRequest.getSignum();
		ResponseHeader header = null;
		UserAuthenticationResponse response = new UserAuthenticationResponse();
		if (CommonUtils.isBlank(signum)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			response.setResponseHeader(header);
			return response;
		}
		UserAuthData authData = dataService.authenticateUser(signum);
		if (CommonUtils.isNull(authData)) {
			header = CommonUtils.generateResponseHeader(STATUS.USER_NOT_EXIST);
			response.setResponseHeader(header);
			return response;
		}
		UserAuthenticationData authenticationData = new UserAuthenticationData();
		BeanUtils.copyProperties(authData, authenticationData);
		response.setUserAuthenticationData(authenticationData);
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}

	// Done
	public UserRegistrationResponse registerUser(UserRegistrationRequest registrationRequest) {
		UserAuthenticationData adminRequestData = registrationRequest.getUserAuthorityData();
		UserAuthenticationData userRequestData = registrationRequest.getUserAuthenticationData();
		BasicResourceDetails basicInfo = registrationRequest.getBasicResourceDetails();
		DetailedResourceDetails detailInfo = registrationRequest.getDetailedResourceDetails();
		UserAuthData adminActualData = dataService.authenticateUser(adminRequestData.getSignum());
		UserAuthData adminReqData = new UserAuthData();
		UserRegistrationResponse registrationResponse = new UserRegistrationResponse();
		ResponseHeader header = new ResponseHeader();
		if (null == adminActualData) {
			header = CommonUtils.generateResponseHeader(STATUS.USER_NOT_EXIST);
			registrationResponse.setResponseHeader(header);
			return registrationResponse;
		}
		BeanUtils.copyProperties(adminRequestData, adminReqData);
		if (!(adminReqData.getSignum().equals(adminActualData.getSignum())
				&& adminReqData.getRole().contains("Admin"))) {
			header = CommonUtils.generateResponseHeader(STATUS.UNAUTHORIZED);
			registrationResponse.setResponseHeader(header);
			return registrationResponse;
		}
		if (CommonUtils.isBlank(userRequestData.getSignum()) || CommonUtils.isBlank(userRequestData.getPassword())
				|| CommonUtils.isBlank(userRequestData.getRole())) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			registrationResponse.setResponseHeader(header);
			return registrationResponse;
		}
		UserAuthData newUserData = new UserAuthData();
		BeanUtils.copyProperties(userRequestData, newUserData);
		try {
			dataService.addAuthInfo(newUserData);
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage().contains("ConstraintViolationException")) {
				header = CommonUtils.generateResponseHeader(STATUS.USER_ALREADY_EXIST);
				registrationResponse.setResponseHeader(header);
				return registrationResponse;
			}
		}
		ResourceBasicInfo basic = new ResourceBasicInfo();
		BeanUtils.copyProperties(basicInfo, basic);
		try {
			dataService.addBasicResourceDetails(basic);
		} catch (Exception e) {
			e.printStackTrace();
			header = CommonUtils.generateResponseHeader(STATUS.UNHANDLED_EXCEPTION);
			registrationResponse.setResponseHeader(header);
			return registrationResponse;
		}

		ResourceDetailedInformation detail = new ResourceDetailedInformation();
		BeanUtils.copyProperties(detailInfo, detail);
		detail.setJoiningDate(CommonUtils.getDate(detailInfo.getJoiningDate()));
		detail.setExpectedStartdate(CommonUtils.getDate(detailInfo.getExpectedStartdate()));
		detail.setRolloffDate(CommonUtils.getDate(detailInfo.getRolloffDate()));
		detail.setUpdateTimestamp(new Date());
		try {
			dataService.addDetailedResourceDetails(detail);
		} catch (Exception e) {
			e.printStackTrace();
			header = CommonUtils.generateResponseHeader(STATUS.UNHANDLED_EXCEPTION);
			registrationResponse.setResponseHeader(header);
			return registrationResponse;
		}
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		registrationResponse.setResponseHeader(header);
		return registrationResponse;
	}

	// Done
	public ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest) {
		String signum = changePasswordRequest.getSignum();
		ChangePasswordResponse changePasswordResponse = new ChangePasswordResponse();
		ResponseHeader header = new ResponseHeader();
		if (CommonUtils.isBlank(signum)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			changePasswordResponse.setResponseHeader(header);
			return changePasswordResponse;
		}
		UserAuthData existingAuthData = dataService.authenticateUser(signum);
		if (null == existingAuthData) {
			header = CommonUtils.generateResponseHeader(STATUS.USER_NOT_EXIST);
			changePasswordResponse.setResponseHeader(header);
			return changePasswordResponse;
		}
		if (CommonUtils.isBlank(existingAuthData.getPassword())
				|| !existingAuthData.getPassword().equals(changePasswordRequest.getCurrentPassword())) {
			header = CommonUtils.generateResponseHeader(STATUS.UNAUTHORIZED);
			changePasswordResponse.setResponseHeader(header);
			return changePasswordResponse;
		}
		if (CommonUtils.isBlank(changePasswordRequest.getNewPassword())) {
			header = CommonUtils.generateResponseHeader(STATUS.INPUT_ERROR);
			changePasswordResponse.setResponseHeader(header);
			return changePasswordResponse;
		}
		UserAuthData newAuthData = new UserAuthData();
		BeanUtils.copyProperties(existingAuthData, newAuthData);
		newAuthData.setPassword(changePasswordRequest.getNewPassword());
		dataService.changePassword(newAuthData);
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		changePasswordResponse.setResponseHeader(header);
		return changePasswordResponse;
	}

	// Done
	public GetBasicResourceDetailsResponse getBasicResourceDetails(GetBasicResourceDetailsRequest request) {
		String signum = request.getSignum();
		GetBasicResourceDetailsResponse response = new GetBasicResourceDetailsResponse();
		ResponseHeader header = new ResponseHeader();
		if (CommonUtils.isBlank(signum)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			response.setResponseHeader(header);
			return response;
		}
		ResourceBasicInfo basicInfo = dataService.getBasicResourceDetails(signum);
		if (null == basicInfo) {
			header = CommonUtils.generateResponseHeader(STATUS.USER_NOT_EXIST);
			response.setResponseHeader(header);
			return response;
		}
		BasicResourceDetails basicResourceDetails = new BasicResourceDetails();
		BeanUtils.copyProperties(basicInfo, basicResourceDetails);
		response.setBasicResourceDetails(basicResourceDetails);
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}

	// Done
	public UpdateBasicResourceDetailsResponse updateBasicResourceDetails(UpdateBasicResourceDetailsRequest request) {
		String signum = request.getBasicResourceDetails().getSignum();
		UpdateBasicResourceDetailsResponse response = new UpdateBasicResourceDetailsResponse();
		ResponseHeader header = new ResponseHeader();
		if (CommonUtils.isBlank(signum)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			response.setResponseHeader(header);
			return response;
		}
		ResourceBasicInfo updateInfo = new ResourceBasicInfo();
		BeanUtils.copyProperties(request.getBasicResourceDetails(), updateInfo);
		dataService.updateBasicResourceDetails(updateInfo);
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}

	// Done
	public GetCurrentActivityResponse getCurrentActivityDetails(GetCurrentActivityRequest getCurrentActivityRequest) {
		String signum = getCurrentActivityRequest.getSignum();
		GetCurrentActivityResponse response = new GetCurrentActivityResponse();
		ResponseHeader header = new ResponseHeader();
		if (CommonUtils.isBlank(signum)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			response.setResponseHeader(header);
			return response;
		}
		List<ResourceCurrentActivity> activities = dataService.getCurrentActivityDetails(signum);
		if (null != activities && activities.size() > 0) {
			for (ResourceCurrentActivity activity : activities) {
				CurrentActivityDetails act = new CurrentActivityDetails();
				BeanUtils.copyProperties(activity, act);
				act.setUpdateTimestamp(CommonUtils.getXmlGregorianCalendar(activity.getUpdateTimestamp()));
				if (null != activity.getDeadline())
					act.setDeadline(CommonUtils.getXmlGregorianCalendar(activity.getDeadline()));
				else
					act.setDeadline(CommonUtils.getXmlGregorianCalendar(new Date(Long.MAX_VALUE)));
				response.getCurrentActivityDetails().add(act);
				if(null==act.getStatus())
					act.setStatus("green");
			}
		} else {
			header = CommonUtils.generateResponseHeader(STATUS.EMPTY_ACTIVITY_LIST);
			response.setResponseHeader(header);
			return response;
		}
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}
	
	public GetCurrentActivityResponse getAllActivityDetails() {
		GetCurrentActivityResponse response = new GetCurrentActivityResponse();
		ResponseHeader header = new ResponseHeader();
		List<ResourceCurrentActivity> activities = null;
		try{
			activities = dataService.getAllActivityDetails();
		}catch (Exception e){
			e.printStackTrace();
		}
		if (null != activities && activities.size() > 0) {
			for (ResourceCurrentActivity activity : activities) {
				CurrentActivityDetails act = new CurrentActivityDetails();
				BeanUtils.copyProperties(activity, act);
				act.setUpdateTimestamp(CommonUtils.getXmlGregorianCalendar(activity.getUpdateTimestamp()));
				if (null != activity.getDeadline())
					act.setDeadline(CommonUtils.getXmlGregorianCalendar(activity.getDeadline()));
				else
					act.setDeadline(CommonUtils.getXmlGregorianCalendar(new Date(Long.MAX_VALUE)));
				response.getCurrentActivityDetails().add(act);
				if(null==act.getStatus())
					act.setStatus("green");
			}
		} else {
			header = CommonUtils.generateResponseHeader(STATUS.EMPTY_ACTIVITY_LIST);
			response.setResponseHeader(header);
			return response;
		}
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}

	// Done
	public UpdateCurrentActivityResponse updateCurrentActivityDetails(
			UpdateCurrentActivityRequest updateCurrentActivityRequest) {
		UpdateCurrentActivityResponse response = new UpdateCurrentActivityResponse();
		ResponseHeader header = new ResponseHeader();
		String signum = updateCurrentActivityRequest.getCurrentActivityDetails().getSignum();
		if (CommonUtils.isBlank(signum)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			response.setResponseHeader(header);
			return response;
		}
		ResourceCurrentActivity updateInfo = new ResourceCurrentActivity();
		BeanUtils.copyProperties(updateCurrentActivityRequest.getCurrentActivityDetails(), updateInfo);
		updateInfo.setUpdateTimestamp(new Date());
		updateInfo.setDeadline(
				CommonUtils.getDate(updateCurrentActivityRequest.getCurrentActivityDetails().getDeadline()));
		dataService.updateCurrentActivityDetails(updateInfo);
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}

	// Done
	public GetDetailedResourceDetailsResponse getDetailedResourceDetails(
			GetDetailedResourceDetailsRequest getDetailedResourceDetailsRequest) {
		GetDetailedResourceDetailsResponse response = new GetDetailedResourceDetailsResponse();
		ResponseHeader header = new ResponseHeader();
		String signum = getDetailedResourceDetailsRequest.getSignum();
		if (CommonUtils.isBlank(signum)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			response.setResponseHeader(header);
			return response;
		}
		ResourceDetailedInformation resourceDetails = dataService.getDetailedResourceDetails(signum);
		if (null == resourceDetails) {
			header = CommonUtils.generateResponseHeader(STATUS.EMPTY_RESOURCE_LIST);
			response.setResponseHeader(header);
			return response;
		}
		DetailedResourceDetails details = new DetailedResourceDetails();
		BeanUtils.copyProperties(resourceDetails, details);
		details.setExpectedStartdate(CommonUtils.getXmlGregorianCalendar(resourceDetails.getExpectedStartdate()));
		details.setJoiningDate(CommonUtils.getXmlGregorianCalendar(resourceDetails.getJoiningDate()));
		details.setRolloffDate(CommonUtils.getXmlGregorianCalendar(resourceDetails.getRolloffDate()));
		details.setUpdateTimestamp(CommonUtils.getXmlGregorianCalendar(resourceDetails.getUpdateTimestamp()));
		response.setDetailedResourceDetails(details);
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}

	public UpdateDetailedResourceDetailsResponse updateDetailedResourceDetails(
			UpdateDetailedResourceDetailsRequest updateDetailedResourceDetailsRequest) {
		UpdateDetailedResourceDetailsResponse response = new UpdateDetailedResourceDetailsResponse();
		ResponseHeader header = new ResponseHeader();
		DetailedResourceDetails details = updateDetailedResourceDetailsRequest.getDetailedResourceDetails();
		if (null == details) {
			header = CommonUtils.generateResponseHeader(STATUS.EMPTY_RESOURCE_LIST);
			response.setResponseHeader(header);
			return response;
		}
		ResourceDetailedInformation detailedInfo = new ResourceDetailedInformation();
		BeanUtils.copyProperties(details, detailedInfo);
		detailedInfo.setExpectedStartdate(CommonUtils.getDate(details.getExpectedStartdate()));
		detailedInfo.setRolloffDate(CommonUtils.getDate(details.getRolloffDate()));
		detailedInfo.setJoiningDate(CommonUtils.getDate(details.getJoiningDate()));
		detailedInfo.setUpdateTimestamp(new Date());
		try {
			dataService.updateDetailedResourceDetails(detailedInfo);
		} catch (Exception e) {
			header = CommonUtils.generateResponseHeader(STATUS.UNHANDLED_EXCEPTION);
			response.setResponseHeader(header);
			return response;
		}
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}

	public GetDetailedResourceDetailsByManagerResponse getDetailedResourceDetailsByManager(
			GetDetailedResourceDetailsByManagerRequest getDetailedResourceDetailsByManagerRequest) {
		GetDetailedResourceDetailsByManagerResponse response = new GetDetailedResourceDetailsByManagerResponse();
		ResponseHeader header = new ResponseHeader();
		String signum = getDetailedResourceDetailsByManagerRequest.getManagerSignum();
		if (CommonUtils.isBlank(signum)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			response.setResponseHeader(header);
			return response;
		}
		List<ResourceDetailedInformation> detailedInfo = dataService.getDetailedResourceDetailsByManager(signum);
		if (null != detailedInfo && detailedInfo.size() > 0) {
			for (ResourceDetailedInformation info : detailedInfo) {
				DetailedResourceDetails detail = new DetailedResourceDetails();
				BeanUtils.copyProperties(info, detail);
				detail.setExpectedStartdate(CommonUtils.getXmlGregorianCalendar(info.getExpectedStartdate()));
				detail.setJoiningDate(CommonUtils.getXmlGregorianCalendar(info.getJoiningDate()));
				detail.setRolloffDate(CommonUtils.getXmlGregorianCalendar(info.getRolloffDate()));
				detail.setUpdateTimestamp(CommonUtils.getXmlGregorianCalendar(info.getUpdateTimestamp()));
				response.getDetailedResourceDetails().add(detail);
			}
		} else {
			header = CommonUtils.generateResponseHeader(STATUS.EMPTY_RESOURCE_LIST);
			response.setResponseHeader(header);
			return response;
		}
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}

	public GetResourcesByRoleResponse getResourceByRole(GetResourcesByRoleRequest getResourceByRoleRequest) {
		String role = getResourceByRoleRequest.getRole();
		GetResourcesByRoleResponse response = new GetResourcesByRoleResponse();
		ResponseHeader header = new ResponseHeader();
		if (CommonUtils.isBlank(role)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			response.setResponseHeader(header);
			return response;
		}
		List<String> resources = dataService.getResourceByRole(role);
		if (null != resources && resources.size() > 0) {
			for (String resource : resources) {
				response.getResources().add(resource);
			}
			header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		} else {
			header = CommonUtils.generateResponseHeader(STATUS.EMPTY_RESOURCE_LIST);
		}
		response.setResponseHeader(header);
		return response;
	}

	public GetResourcesByManagerResponse getResourcesByManager(GetResourcesByManagerRequest request) {
		GetResourcesByManagerResponse response = new GetResourcesByManagerResponse();
		ResponseHeader header = new ResponseHeader();
		String signum = request.getSignum();
		if (CommonUtils.isBlank(signum)) {
			header = CommonUtils.generateResponseHeader(STATUS.MANDATORY_PARAM_MISSING);
			response.setResponseHeader(header);
			return response;
		}
		UserAuthData authResponse = new UserAuthData();
		authResponse = dataService.authenticateUser(signum);
		if (null != authResponse && null != authResponse.getRole() && authResponse.getRole().contains("LM")) {

		} else {
			header = CommonUtils.generateResponseHeader(STATUS.UNAUTHORIZED);
			response.setResponseHeader(header);
			return response;
		}
		List<String> resourceList = dataService.getResourcesByManager(signum);
		if (null == resourceList || resourceList.size() == 0) {
			header = CommonUtils.generateResponseHeader(STATUS.EMPTY_RESOURCE_LIST);
			response.setResponseHeader(header);
			return response;
		}
		response.getResources().addAll(resourceList);
		header = CommonUtils.generateResponseHeader(STATUS.SUCCESSFUL);
		response.setResponseHeader(header);
		return response;
	}

	// Get resource and manager mapping

	public void createTable() {
		dataService.addBasicResourceDetails(null);
		dataService.addAuthInfo(null);
	}

}
