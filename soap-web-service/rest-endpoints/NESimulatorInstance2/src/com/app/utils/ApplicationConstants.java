package com.app.utils;

public class ApplicationConstants {
	
	public static final int HTTP_PORT = Integer.parseInt(CommonUtils.getApplicationProperties("http.port"));
	public static final int TELNET_PORT = Integer.parseInt(CommonUtils.getApplicationProperties("telnet.port"));
	public static final int TELNET_THREADSIZE = Integer.parseInt(CommonUtils.getApplicationProperties("telnet.threadsize"));
	public static final String HTTP_METHOD_POST = "POST";
	public static final String HTTP_METHOD_GET = "GET";
	public static final String APPLICATION_PROPERTIES_DEFINITIONS = "resources/application.properties";
	public static final String CONTEXT_PROPERTIES_DEFINITIONS = "resources/httpcontext.properties";
	public static final String TELNET_PROPERTIES_DEFINITIONS = "resources/telnet.properties";
	public static final String LOG_FILE_LOCATION = "logs/request.log";
	public static final String CHAR_ENCODING = "UTF-8";
	public static final String PROPERTY_SPLITTER_AT = "@";
	public static final String PROPERTY_SPLITTER_EQ = "=";
	public static final String EMPTY_STRING = "";
	public static final String TELNET_PROMPT_USERNAME = "USERNAME:";
	public static final String TELNET_PROMPT_PASSWORD = "PASSWORD:";
	public static final String NEW_LINE_ENTER_KEY = "\r\n";
	public static final String LOGOUT_THANK_YOU = "THANK YOU FOR USING TCP SERVICE \r\n";
	public static final String LOGOUT_SESSION_EXPIRED = "SESSION EXPIRED... LOGIN AGAIN...\r\n";
	public static final String ENTER_QUERY = CommonUtils.getApplicationProperties("telnet.query.prompt");
	public static final String USER_INPUT_LOGOUT = "LOGOUT";
	public static final String RESPONSE_NOT_FOUND = "RESPONSE NOT FOUND";
	public static final String LOGIN_STATUS_TRUE = "TRUE";
	public static final String LOGIN_STATUS_FALSE = "FALSE";
	
}
