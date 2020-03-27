package com.app.telnet;

import static com.app.telnet.STATE.STATE_INITIALIZING;
import static com.app.telnet.STATE.STATE_PASSWORD_PROMPT;
import static com.app.telnet.STATE.STATE_QUERY_PROMPT;
import static com.app.telnet.STATE.STATE_RETRY_PROMPT;
import static com.app.telnet.STATE.STATE_USERNAME_PROMPT;

import java.io.IOException;

import com.app.utils.ApplicationConstants;
import com.app.utils.CommonUtils;

public class SecureTelnetIOManager extends AbstractTelnetManager{
	
	private SecureTelnetIOManager(){}
	
	private static SecureTelnetIOManager ioManager = null;
	
	public static SecureTelnetIOManager getInstance(){
		if (ioManager == null)
			ioManager = new SecureTelnetIOManager();
		return ioManager;
	}

	private STATE state = STATE_INITIALIZING;

	public void setState(STATE state) {
		this.state = state;
	}

	private static String username;
	private static String password;

	public String processInput(String in) throws IOException {
		String out = ApplicationConstants.EMPTY_STRING;
		if(null!=in && in.equals(ApplicationConstants.USER_INPUT_LOGOUT)){
			out = out + ApplicationConstants.LOGOUT_THANK_YOU;
			out = out + ApplicationConstants.LOGOUT_SESSION_EXPIRED;
			out = out + ApplicationConstants.TELNET_PROMPT_USERNAME;
			state = STATE_USERNAME_PROMPT;
			return out;
		}

		if (state == STATE_INITIALIZING) {
			out = ApplicationConstants.TELNET_PROMPT_USERNAME;
			state = STATE_USERNAME_PROMPT;
		} else if (state == STATE_USERNAME_PROMPT) {
			username = in;
			out = ApplicationConstants.TELNET_PROMPT_PASSWORD;
			state = STATE_PASSWORD_PROMPT;
		} else if (state == STATE_PASSWORD_PROMPT) {
			password = in;
			String authMessage = TelnetUtils.authenticate(username, password);
			String status = authMessage.split("#")[0];
			String message = authMessage.split("#")[1];
			if (status.equals(ApplicationConstants.LOGIN_STATUS_TRUE)) {
				out = ApplicationConstants.ENTER_QUERY;
				state = STATE_QUERY_PROMPT;
			} else {
				state = STATE_RETRY_PROMPT;
				out = message+ApplicationConstants.NEW_LINE_ENTER_KEY;
				out = out + ApplicationConstants.TELNET_PROMPT_USERNAME;
				state = STATE_USERNAME_PROMPT;
			}
		} else if (state == STATE_QUERY_PROMPT) {
			CommonUtils.printLogs("Requested Query: "+in);
			out = ApplicationConstants.NEW_LINE_ENTER_KEY;
			out = out + "----------------------------------------------------------------------"+ApplicationConstants.NEW_LINE_ENTER_KEY;
			String resp = ApplicationConstants.EMPTY_STRING;
			resp = TelnetUtils.getResponseString(in);
			out = out + resp+ApplicationConstants.NEW_LINE_ENTER_KEY;
			out = out + "----------------------------------------------------------------------"+ApplicationConstants.NEW_LINE_ENTER_KEY;
			out = out + ApplicationConstants.ENTER_QUERY;
			state = STATE_QUERY_PROMPT;
		}
		return out;
	}
}