package com.ericsson.mdc.dblink.services.orm;

import java.util.List;

import com.ericsson.mdc.dblink.entity.ResourceDetailedInformation;

public interface ResourceDetailedInformationDao {

	public ResourceDetailedInformation getDetailedResourceDetails(String signum);

	public List<ResourceDetailedInformation> getDetailedResourceDetailsByManager(String signum);
	
	public void addDetailedResourceDetails(ResourceDetailedInformation details);
	
	public void updateDetailedResourceDetails(ResourceDetailedInformation details);
	
	public List<String> getResourcesByManager(String signum);
}
