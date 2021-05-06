package com.ericsson.mdc.dblink.services.orm;

import java.util.List;

import com.ericsson.mdc.dblink.entity.UserAuthData;

public interface UserAuthenticationDao {
	
	public UserAuthData authenticateUser(String signum);

	public int addAuthInfo(UserAuthData request);

	public int changePassword(UserAuthData request);
	
	public List<String> getResourceByRole(String role);

}
