package com.ericsson.mdc.dblink.constants;

public class StatusCodes {

	public static enum STATUS {
		SUCCESSFUL,
		UNAUTHORIZED,
		MANDATORY_PARAM_MISSING,
		UNHANDLED_EXCEPTION,
		USER_NOT_EXIST,
		USER_ALREADY_EXIST,
		EMPTY_RESOURCE_LIST,
		EMPTY_ACTIVITY_LIST,
		INPUT_ERROR
	}

	public static final String OPERATION_SUCCESS = "0";
	public static final String MESSAGE_SUCCESSFUL = "Operation Successful";
	public static final String OPERATION_UNAUTHORIZED = "-100";
	public static final String MESSAGE_UNAUTHORIZED = "Unauthorized to Perform Operation";
	public static final String MANDATORY_PARAM_MISSING = "-3";
	public static final String MESSAGE_MANDATORY_PARAM_MISSING = "Mandatory Parameter Missing.";
	public static final String OTHER_EXCEPTION = "-999";
	public static final String MESSAGE_OTHER_EXCEPTION = "Caught Unhandled Exception.";
	public static final String USER_NOT_EXISTS = "-11";
	public static final String MESSAGE_USER_NOT_EXISTS = "User Doesnt Exist.";
	public static final String USER_ALREADY_EXISTS = "-12";
	public static final String MESSAGE_USER_ALREADY_EXISTS = "User Already Exist.";
	public static final String EMPTY_RESOURCE_LIST = "-101";
	public static final String MESSAGE_EMPTY_RESOURCE_LIST = "Resource list is empty- no resource found.";
	public static final String EMPTY_ACTIVITY_LIST = "-102";
	public static final String MESSAGE_EMPTY_ACTIVITY_LIST = "Activity list is empty- no activity found.";
	public static final String ERROR_INPUT_DATA = "-2";
	public static final String MESSAGE_ERROR_INPUT_DATA = "There is one or more error in the input.";
	public static final String SOURCE_DBLINK = "DBLink";
	public static final String SOURCE_MDCDB = "MDC_DB";
	public static final String MESSAGE_ERROR_DATABASE = "Error in Database Operation";

}
