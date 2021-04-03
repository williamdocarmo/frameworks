package com.ericsson.mdc.dblink.services.orm;

import java.util.List;

import com.ericsson.mdc.dblink.entity.ResourceCurrentActivity;

public interface CurrentActivityDetailsDao {

	public void updateCurrentActivityDetails(ResourceCurrentActivity request);

	public List<ResourceCurrentActivity> getCurrentActivityDetails(String signum);
	
	public List<ResourceCurrentActivity> getAllActivityDetails();
	
}
