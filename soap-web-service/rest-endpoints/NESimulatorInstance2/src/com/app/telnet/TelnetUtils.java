package com.app.telnet;

import static com.app.utils.CommonUtils.applicationProperties;
import static com.app.utils.CommonUtils.telnetProperties;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.app.utils.ApplicationConstants;
import com.app.utils.CommonUtils;

public class TelnetUtils {

	public static String authenticate(String username, String password) {
		String status = "";
		String message = "";
		if (CommonUtils.isEmpty(username) || CommonUtils.isEmpty(password)) {
			status = ApplicationConstants.LOGIN_STATUS_FALSE;
			message = "USERNAME AND PASSWORD CANNOT BE BLANK...";
		} else if (CommonUtils.isEmpty(applicationProperties.get("telnet.username"))
				|| CommonUtils.isEmpty(applicationProperties.get("telnet.password"))) {
			status = ApplicationConstants.LOGIN_STATUS_FALSE;
			message = "USERNAME AND PASSWORD NOT PRESENT IN CONFIG...";
		} else if (!String.valueOf(applicationProperties.get("telnet.username")).equals(username)) {
			status = ApplicationConstants.LOGIN_STATUS_FALSE;
			message = "USER NAME IS INCORRECT...";
		} else if (!applicationProperties.get("telnet.password").equals(password)) {
			status = ApplicationConstants.LOGIN_STATUS_FALSE;
			message = "USER EXISTS BUT PASSWORD IS INCORRECT...";
		} else {
			status = ApplicationConstants.LOGIN_STATUS_TRUE;
			message = "SUCCESSFUL AUTHENTICATION...";
		}
		return status + "#" + message;
	}

	public static String getResponseString(String query) {
		String response = "";
		String responseFilename = "";
		if (null!=query && telnetProperties.containsKey(query)) {
			try {
				responseFilename = telnetProperties.getProperty(query);
				response = new String(Files.readAllBytes(Paths.get(responseFilename)),
						ApplicationConstants.CHAR_ENCODING);
			} catch (IOException e) {
				response = "Response file not found!";
			}
		} else {
			response = "Query [" + query + "] Not Mapped!";
		}
		return response;
	}
	
	public static List<Object> getTelnetCommands(){
		return new ArrayList<Object>(telnetProperties.keySet());
	}
	
	public static boolean isSecure(){
		Boolean secure = (Boolean) applicationProperties.get("telnet.auth");
		return secure;
	}

}
