package com.app.telnet;

import java.io.IOException;

import com.app.utils.ApplicationConstants;
import com.app.utils.CommonUtils;

public class TelnetIOManager extends AbstractTelnetManager{

	private TelnetIOManager() {}

	private static TelnetIOManager ioManager = null;

	public static TelnetIOManager getInstance() {
		if (ioManager == null)
			ioManager = new TelnetIOManager();
		return ioManager;
	}

	public String processInput(String in) throws IOException {
		if(CommonUtils.isEmpty(in))
			return "";
		String out = ApplicationConstants.EMPTY_STRING;
		CommonUtils.printLogs("Requested Query: " + in);
		out = ApplicationConstants.NEW_LINE_ENTER_KEY;
		//out = out + "----------------------------------------------------------------------" + ApplicationConstants.NEW_LINE_ENTER_KEY;
		out = out + TelnetUtils.getResponseString(in);
		out = out + ApplicationConstants.NEW_LINE_ENTER_KEY;
		//out = out + "----------------------------------------------------------------------" + ApplicationConstants.NEW_LINE_ENTER_KEY;
		//out = out + ApplicationConstants.ENTER_QUERY;
		return out;
	}

}