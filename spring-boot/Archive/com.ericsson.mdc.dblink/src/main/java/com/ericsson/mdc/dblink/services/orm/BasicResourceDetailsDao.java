package com.ericsson.mdc.dblink.services.orm;

import com.ericsson.mdc.dblink.entity.ResourceBasicInfo;

public interface BasicResourceDetailsDao {

	public ResourceBasicInfo getBasicResourceDetails(String signum);

	public void updateBasicResourceDetails(ResourceBasicInfo request);

	public void addBasicResourceDetails(ResourceBasicInfo request);

}
