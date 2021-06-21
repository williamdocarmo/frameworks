package com.app.jmx;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Application {

	public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException,
			MBeanRegistrationException, NotCompliantMBeanException, InstanceNotFoundException, InterruptedException,
			IntrospectionException, ReflectionException {

		System.setProperty("com.sun.management.jmxremote.port", "9191");
		ObjectName objectName = new ObjectName("com.app.jmx:type=basic,name=config");
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		server.registerMBean(new ApplicationConfiguration(), objectName);

		while (true) {
		}

		

	}

}


/**
-Djavax.management.builder.initial=
-Dcom.sun.management.jmxremote
-Dcom.sun.management.jmxremote.authenticate=false
-Dcom.sun.management.jmxremote.ssl=false
-Dcom.sun.management.jmxremote.port=9000
*/