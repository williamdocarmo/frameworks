package com.app.sim.launcher;

import java.net.InetAddress;

import com.app.http.HTTPServer;
import com.app.telnet.TelnetServer;
import com.app.utils.ApplicationConstants;
import com.app.utils.CommonUtils;

public class ServerLauncher {

	public static void main(String[] args) throws Exception {
		HTTPServer.start();
		TelnetServer.start();
		CommonUtils.printLogs("HTTP Server started running on \t\t:"+InetAddress.getLocalHost().getHostAddress()+":"+ApplicationConstants.HTTP_PORT);
		CommonUtils.printLogs("Telnet Server started running on \t:"+InetAddress.getLocalHost().getHostAddress()+":"+ApplicationConstants.TELNET_PORT);
	}

}