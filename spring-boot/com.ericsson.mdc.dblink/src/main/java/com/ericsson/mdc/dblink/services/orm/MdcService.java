package com.ericsson.mdc.dblink.services.orm;

import java.util.List;

import com.ericsson.mdc.dblink.entity.ResourceBasicInfo;
import com.ericsson.mdc.dblink.entity.ResourceCurrentActivity;
import com.ericsson.mdc.dblink.entity.ResourceDetailedInformation;
import com.ericsson.mdc.dblink.entity.UserAuthData;

public interface MdcService {

	public UserAuthData authenticateUser(String signum);

	public void addAuthInfo(UserAuthData request);

	public void changePassword(UserAuthData request);
	
	public List<String> getResourceByRole(String role);

	public ResourceBasicInfo getBasicResourceDetails(String signum);

	public void updateBasicResourceDetails(ResourceBasicInfo request);

	public void addBasicResourceDetails(ResourceBasicInfo basicInfo);

	public void updateCurrentActivityDetails(ResourceCurrentActivity request);

	public List<ResourceCurrentActivity> getCurrentActivityDetails(String signum);
	
	public List<ResourceCurrentActivity> getAllActivityDetails();

	public ResourceDetailedInformation getDetailedResourceDetails(String signum);

	public List<ResourceDetailedInformation> getDetailedResourceDetailsByManager(String signum);
	
	public void addDetailedResourceDetails(ResourceDetailedInformation details);
	
	public void updateDetailedResourceDetails(ResourceDetailedInformation details);
	
	public List<String> getResourcesByManager(String signum);

}
