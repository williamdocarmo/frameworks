package com.app.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class ApplicationConfiguration extends NotificationBroadcasterSupport implements ApplicationConfigurationMBean {

	private String remoteHost;

	private String remotePort;

	private String username;

	private String password;

	@Override
	public String getRemoteHost() {
		return remoteHost;
	}

	@Override
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	@Override
	public String getRemotePort() {
		return remotePort;
	}

	@Override
	public void setRemotePort(String remotePort) {
		this.remotePort = remotePort;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		String oldPassword = this.password;
		this.password = password;
		Notification notification = new AttributeChangeNotification(this, 1, System.currentTimeMillis(),
				"Password Changed", "password", "String", oldPassword, password);
		sendNotification(notification);
	}

	public String displayConfiguration(boolean display) {
		if (display) {
			return "Current Configuration is: " + this.toString();
		} else {
			return "Unable to Display Configuration";
		}

	}

	@Override
	public void resetOperation(boolean reset, String state) {
		if (!reset) {
			System.out.println("Unable to Reset Configuration");
		} else if (state.equals("reset")) {
			this.username = "";
			this.password = "";
			this.remoteHost = "";
			this.remotePort = "";
		} else if (state.equals("default")) {
			this.username = "default_user";
			this.password = "default_pass";
			this.remoteHost = "localhost";
			this.remotePort = "0";
		} else {
			System.out.println("Unknown State: Unable to Reset Configuration");
		}
		displayConfiguration(reset);

	}

	public ApplicationConfiguration() {
		super();
		this.username = "default_user";
		this.password = "default_pass";
		this.remoteHost = "localhost";
		this.remotePort = "0";
	}

	@Override
	public String toString() {
		return "ApplicationConfiguration [remoteHost=" + remoteHost + ", remotePort=" + remotePort + ", username="
				+ username + ", password=" + password + "]";
	}

	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
		String name = AttributeChangeNotification.class.getName();
		String description = "An attribute of this MBean has changed";
		MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
		return new MBeanNotificationInfo[] { info };
	}

}
