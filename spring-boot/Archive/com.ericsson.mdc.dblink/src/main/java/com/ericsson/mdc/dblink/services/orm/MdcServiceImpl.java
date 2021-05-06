package com.ericsson.mdc.dblink.services.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ericsson.mdc.dblink.entity.ResourceBasicInfo;
import com.ericsson.mdc.dblink.entity.ResourceCurrentActivity;
import com.ericsson.mdc.dblink.entity.ResourceDetailedInformation;
import com.ericsson.mdc.dblink.entity.UserAuthData;

@Component
public class MdcServiceImpl implements MdcService {

	@Autowired
	BasicResourceDetailsDao basicResourceDetailsDao;

	@Autowired
	CurrentActivityDetailsDao currentActivityDetailsDao;

	@Autowired
	ResourceDetailedInformationDao resourceDetailedInformationDao;

	@Autowired
	UserAuthenticationDao userAuthenticationDao;

	@Override
	public UserAuthData authenticateUser(String signum) {
		return userAuthenticationDao.authenticateUser(signum);
	}

	@Override
	public void addAuthInfo(UserAuthData request) {
		userAuthenticationDao.addAuthInfo(request);
	}

	@Override
	public List<String> getResourceByRole(String role) {
		return userAuthenticationDao.getResourceByRole(role);
	}

	@Override
	public void changePassword(UserAuthData request) {
		userAuthenticationDao.changePassword(request);
	}

	@Override
	public ResourceBasicInfo getBasicResourceDetails(String signum) {
		return basicResourceDetailsDao.getBasicResourceDetails(signum);
	}

	@Override
	public void updateBasicResourceDetails(ResourceBasicInfo request) {
		basicResourceDetailsDao.updateBasicResourceDetails(request);
	}

	@Override
	public void addBasicResourceDetails(ResourceBasicInfo basicInfo) {
		basicResourceDetailsDao.addBasicResourceDetails(basicInfo);
	}

	@Override
	public void updateCurrentActivityDetails(ResourceCurrentActivity request) {
		currentActivityDetailsDao.updateCurrentActivityDetails(request);
	}

	@Override
	public List<ResourceCurrentActivity> getCurrentActivityDetails(String signum) {
		return currentActivityDetailsDao.getCurrentActivityDetails(signum);
	}
	
	@Override
	public List<ResourceCurrentActivity> getAllActivityDetails(){
		return currentActivityDetailsDao.getAllActivityDetails();
	}

	@Override
	public ResourceDetailedInformation getDetailedResourceDetails(String signum) {
		return resourceDetailedInformationDao.getDetailedResourceDetails(signum);
	}

	@Override
	public List<ResourceDetailedInformation> getDetailedResourceDetailsByManager(String signum) {
		return resourceDetailedInformationDao.getDetailedResourceDetailsByManager(signum);
	}

	@Override
	public void addDetailedResourceDetails(ResourceDetailedInformation details) {
		resourceDetailedInformationDao.addDetailedResourceDetails(details);
	}

	@Override
	public void updateDetailedResourceDetails(ResourceDetailedInformation details) {
		resourceDetailedInformationDao.updateDetailedResourceDetails(details);
	}

	@Override
	public List<String> getResourcesByManager(String signum) {
		return resourceDetailedInformationDao.getResourcesByManager(signum);
	}

}
