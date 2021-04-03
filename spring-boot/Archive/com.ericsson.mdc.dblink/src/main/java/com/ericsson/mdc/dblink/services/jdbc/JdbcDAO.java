package com.ericsson.mdc.dblink.services.jdbc;

import java.util.List;

import com.ericsson.mdc.ws.soap.BasicResourceDetails;
import com.ericsson.mdc.ws.soap.ChangePasswordRequest;
import com.ericsson.mdc.ws.soap.CurrentActivityDetails;
import com.ericsson.mdc.ws.soap.DetailedResourceDetails;
import com.ericsson.mdc.ws.soap.UserAuthenticationData;

public interface JdbcDAO {
	
	public UserAuthenticationData authenticateUser(String signum);
	
	public int Milestone(UserAuthenticationData request);
	
	public int changePassword(ChangePasswordRequest request);
	
	public BasicResourceDetails getBasicResourceDetails(String signum);
	
	public int updateBasicResourceDetails(BasicResourceDetails request);
	
	public int addBasicResourceDetails(String signum);
	
	public int updateCurrentActivityDetails(CurrentActivityDetails request);
	
	public List<CurrentActivityDetails> getCurrentActivityDetails(String signum);
	
	public List<DetailedResourceDetails> getDetailedResourceDetails(String signum);
	
	public List<DetailedResourceDetails> getDetailedResourceDetailsByManager(String signum);

}
