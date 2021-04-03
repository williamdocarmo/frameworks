package com.ericsson.mdc.dblink.services.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ericsson.mdc.dblink.utils.CommonUtils;
import com.ericsson.mdc.ws.soap.BasicResourceDetails;
import com.ericsson.mdc.ws.soap.ChangePasswordRequest;
import com.ericsson.mdc.ws.soap.CurrentActivityDetails;
import com.ericsson.mdc.ws.soap.DetailedResourceDetails;
import com.ericsson.mdc.ws.soap.UserAuthenticationData;

@Component
public class JdbcDaoImpl implements JdbcDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserAuthenticationData authenticateUser(String signum) {
		String sql = "SELECT * FROM MDC_USER_AUTH WHERE USERNAME = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { signum }, new UserAuthMapper());
	}

	@Override
	public int Milestone(UserAuthenticationData request) {
		String sql = "Insert into MDC_USER_AUTH (USERNAME,PASSWORD,ROLE,RESOURCE_NAME) values (?,?,?)";
		Object[] params;
		params = new Object[] { request.getSignum(), request.getPassword(), request.getRole() };
		int rowInserted = jdbcTemplate.update(sql, params);
		return rowInserted;
	}

	@Override
	public int changePassword(ChangePasswordRequest request) {
		String sql = "UPDATE MDC_USER_AUTH SET PASSWORD = ? WHERE USERNAME = ?";
		Object[] params;
		params = new Object[] { request.getNewPassword(), request.getSignum() };
		int rowInserted = jdbcTemplate.update(sql, params);
		return rowInserted;
	}

	@Override
	public BasicResourceDetails getBasicResourceDetails(String signum) {
		String sql = "SELECT * FROM MDC_RESOURCE_BASE WHERE SIGNUM=?";
		Object[] params;
		params = new Object[] { signum };
		return jdbcTemplate.queryForObject(sql, params, new BasicResourceDetailsMapper());
	}

	@Override
	public int updateBasicResourceDetails(BasicResourceDetails request) {
		String sql = "UPDATE MDC_RESOURCE_BASE SET PERSON_NO=?,RESOURCE_NAME = ?, EMAIL_ID = ?, PHONE_NO = ?, CURRENT_PROJECT = ? WHERE SIGNUM = ?";
		Object[] params;
		params = new Object[] { request.getPersonNo(), request.getResourceName(), request.getEmailId(), request.getPhoneNo(), request.getCurrentProject(), request.getSignum() };
		int rowInserted = jdbcTemplate.update(sql, params);
		return rowInserted;
	}

	@Override
	public int addBasicResourceDetails(String signum) {
		String sql = "Insert into MDC_RESOURCE_BASE (SIGNUM,PERSON_NO,RESOURCE_NAME, EMAIL_ID, PHONE_NO, CURRENT_PROJECT) values (?,?,?,?,?,?)";
		Object[] params;
		params = new Object[] { signum, "empty", "empty", "empty", "empty", "empty" };
		int rowInserted = jdbcTemplate.update(sql, params);
		return rowInserted;
	}

	@Override
	public int updateCurrentActivityDetails(CurrentActivityDetails request) {
		String sql = "Insert into MDC_CURRENT_ACTIVITY (SIGNUM,CURRENT_PROJECT,CURRENT_MILESTONE, CHALLENGES_FACED, UPDATE_TIMESTAMP) values (?,?,?,?,SYSDATE)";
		Object[] params;
		params = new Object[] { request.getSignum(), request.getCurrentProject(), request.getCurrentMilestone(), request.getChallengesFaced() };
		int rowInserted = jdbcTemplate.update(sql, params);
		return rowInserted;
	}

	@Override
	public List<CurrentActivityDetails> getCurrentActivityDetails(String signum) {
		String sql = "SELECT * FROM MDC_CURRENT_ACTIVITY WHERE SIGNUM = ?";
		Object[] params;
		params = new Object[] { signum };
		return jdbcTemplate.query(sql, params, new CurrentActivityDetailsMapper());
	}

	@Override
	public List<DetailedResourceDetails> getDetailedResourceDetails(String signum) {
		String sql = "SELECT * FROM MDC_RESOURCE_DETAILS WHERE SIGNUM=?";
		Object[] params;
		params = new Object[] { signum };
		return jdbcTemplate.query(sql, params, new DetailedResourceMapper());
	}
	
	@Override
	public List<DetailedResourceDetails> getDetailedResourceDetailsByManager(String signum) {
		String sql = "SELECT * FROM MDC_RESOURCE_DETAILS WHERE LINE_MANAGER=?";
		Object[] params;
		params = new Object[] { signum };
		return jdbcTemplate.query(sql, params, new DetailedResourceMapper());
	}
}

final class UserAuthMapper implements RowMapper<UserAuthenticationData> {

	@Override
	public UserAuthenticationData mapRow(ResultSet resultSet, int arg1) throws SQLException {
		UserAuthenticationData user = new UserAuthenticationData();
		user.setSignum(resultSet.getString("USERNAME"));
		user.setPassword(resultSet.getString("PASSWORD"));
		user.setRole(resultSet.getString("ROLE"));
		return user;
	}

}

final class BasicResourceDetailsMapper implements RowMapper<BasicResourceDetails> {

	@Override
	public BasicResourceDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {
		BasicResourceDetails resource = new BasicResourceDetails();
		resource.setSignum(resultSet.getString("SIGNUM"));
		resource.setPersonNo(resultSet.getString("PERSON_NO"));
		resource.setResourceName(resultSet.getString("RESOURCE_NAME"));
		resource.setEmailId(resultSet.getString("EMAIL_ID"));
		resource.setPhoneNo(resultSet.getString("PHONE_NO"));
		resource.setCurrentProject(resultSet.getString("CURRENT_PROJECT"));
		return resource;
	}

}

final class CurrentActivityDetailsMapper implements RowMapper<CurrentActivityDetails> {

	@Override
	public CurrentActivityDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {
		CurrentActivityDetails activity = new CurrentActivityDetails();
		activity.setSignum(resultSet.getString("SIGNUM"));
		activity.setCurrentProject(resultSet.getString("CURRENT_PROJECT"));
		activity.setCurrentMilestone(resultSet.getString("CURRENT_MILESTONE"));
		activity.setChallengesFaced(resultSet.getString("CHALLENGES_FACED"));
		activity.setUpdateTimestamp(CommonUtils.getXmlGregorianCalendar(resultSet.getString("UPDATE_TIMESTAMP")));
		return activity;
	}

}

final class DetailedResourceMapper implements RowMapper<DetailedResourceDetails> {

	@Override
	public DetailedResourceDetails mapRow(ResultSet resultSet, int arg1) throws SQLException {
		DetailedResourceDetails resourceDetails = new DetailedResourceDetails();
		resourceDetails.setSignum(resultSet.getString("SIGNUM"));
		resourceDetails.setStatus(resultSet.getString("STATUS"));
		resourceDetails.setBillable(resultSet.getBoolean("BILLABLE"));
		resourceDetails.setDeployable(resultSet.getBoolean("DEPLOYABLE"));
		resourceDetails.setJoiningDate(CommonUtils.getXmlGregorianCalendar(resultSet.getString("JOIN_DATE")));
		resourceDetails.setLocation(resultSet.getString("LOCATION"));
		resourceDetails.setPosition(resultSet.getString("POSITION"));
		resourceDetails.setLineManager(resultSet.getString("LINE_MANAGER"));
		resourceDetails.setJobStage(resultSet.getString("JOB_STAGE"));
		resourceDetails.setJobRole(resultSet.getString("ROLE"));
		resourceDetails.setRnamCoreFlexPool(resultSet.getBoolean("RNAM_CORE_FLEX_POOL"));
		resourceDetails.setCdCoreFlexPool(resultSet.getBoolean("CD_CORE_FLEX_POOL"));
		resourceDetails.setLoanResource(resultSet.getBoolean("LOAN_RESOURCE"));
		resourceDetails.setSkillset(resultSet.getString("SKILL"));
		resourceDetails.setProjectStatus(resultSet.getString("PROJECT_STATUS"));
		resourceDetails.setRegion(resultSet.getString("REGION"));
		resourceDetails.setCurrentProject(resultSet.getString("CURRENT_PROJECT"));
		resourceDetails.setRolloffDate(CommonUtils.getXmlGregorianCalendar(resultSet.getString("ROLL_OFF_DATE")));
		resourceDetails.setNextProject(resultSet.getString("NEXT_PROJECT"));
		resourceDetails.setExpectedStartdate(CommonUtils.getXmlGregorianCalendar(resultSet.getString("EXPECTED_START_DATE")));
		resourceDetails.setResignedOrMobility(resultSet.getBoolean("RESIGNED_MOBILITY"));
		resourceDetails.setFullyOccupied(resultSet.getBoolean("FULLY_OCCUPIED"));
		resourceDetails.setUpdateTimestamp(CommonUtils.getXmlGregorianCalendar(resultSet.getString("UPDATE_TIMESTAMP")));
		return resourceDetails;
	}

}