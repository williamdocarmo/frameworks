package com.app.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CommonUtils {

	private CommonUtils() {
	}

	public static Properties applicationProperties = null;
	public static Properties httpContexts = null;
	public static Properties telnetProperties = null;

	static {
		applicationProperties = new Properties();
		httpContexts = new Properties();
		telnetProperties = new Properties();
		try {
			applicationProperties.load(new FileInputStream(ApplicationConstants.APPLICATION_PROPERTIES_DEFINITIONS));
			httpContexts.load(new FileInputStream(ApplicationConstants.CONTEXT_PROPERTIES_DEFINITIONS));
			// List<String> allProps =
			// Files.readAllLines(Paths.get(ApplicationConstants.TELNET_PROPERTIES_DEFINITIONS));
			List<String> allProps = getAllTelnetProps();
			for (String prop : allProps) {
				telnetProperties.put(prop.split(ApplicationConstants.PROPERTY_SPLITTER_EQ)[0].trim(),
						prop.split(ApplicationConstants.PROPERTY_SPLITTER_EQ)[1].trim());
			}
		} catch (Exception e) {
		}
	}

	public static String getApplicationProperties(String property) {
		String propValue = ApplicationConstants.EMPTY_STRING;
		try {
			propValue = applicationProperties.getProperty(property);
		} catch (Exception e) {
		}
		return propValue;
	}

	public static boolean isEmpty(Object obj) {
		if (null == obj)
			return true;
		String string = (String) obj;
		if (string.trim().length() == 0)
			return true;
		return false;
	}

	public static void printLogs(Object obj) {
		System.out.println(obj);
	}

	private static List<String> getAllTelnetProps() {
		List<String> allProperties = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(ApplicationConstants.TELNET_PROPERTIES_DEFINITIONS));
			String line;
			while ((line = br.readLine()) != null) {
				allProperties.add(line);
			}
		} catch (Exception e) {
		}finally{
			try {
				br.close();
			} catch (IOException e) {}
		}
		return allProperties;
	}
}
