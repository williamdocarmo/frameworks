package com.app.http;

import static com.app.utils.CommonUtils.httpContexts;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;

import com.app.utils.ApplicationConstants;
import com.app.utils.CommonUtils;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

public class HttpUtils {

	public static List<String> getContextPaths() {
		List<String> contexts = new ArrayList<String>();
		for (Object context : httpContexts.keySet()) {
			contexts.add(context.toString().split(ApplicationConstants.PROPERTY_SPLITTER_AT)[0]);
		}
		return contexts;
	}

	public static void logRequest(HttpExchange exchange) {
		boolean printBody = Boolean.valueOf(CommonUtils.getApplicationProperties("httpPrintBody"));
		boolean printHeader = Boolean.valueOf(CommonUtils.getApplicationProperties("httpPrintHeader"));
		if (printBody) {
			CommonUtils.printLogs("HTTP METHOD: " + exchange.getRequestMethod());
			InputStream request = exchange.getRequestBody();
			StringWriter writer = new StringWriter();
			CommonUtils.printLogs("---REQUEST BODY STARTS---");
			try {
				IOUtils.copy(request, writer, ApplicationConstants.CHAR_ENCODING);
				CommonUtils.printLogs(writer.toString());
			} catch (IOException e) {
			}
			CommonUtils.printLogs("---REQUEST BODY ENDS---");
		}
		if (printHeader) {
			Headers headers = exchange.getRequestHeaders();
			Set<String> headerNames = headers.keySet();
			CommonUtils.printLogs("---REQUEST HEADER STARTS---");
			System.out.println(exchange.getRequestMethod()+" "+exchange.getRequestURI()+" "+exchange.getProtocol());
			for (String header : headerNames)
				CommonUtils.printLogs("HTTP Header [" + header + "] :: " + headers.get(header));
			CommonUtils.printLogs("---REQUEST HEADER ENDS---");
		}
	}

	public static String getResponseString(HttpExchange exchange) {
		
		String httpResponse = ApplicationConstants.EMPTY_STRING;
		String contextPath = exchange.getHttpContext().getPath();
		String propertyNameForCurrentRequest = contextPath.replaceAll("/", ApplicationConstants.EMPTY_STRING) + ApplicationConstants.PROPERTY_SPLITTER_AT + exchange.getRequestMethod();
		String responseFilename = httpContexts.getProperty(propertyNameForCurrentRequest);

		if (httpContexts.containsKey(propertyNameForCurrentRequest)) {
			try {
				httpResponse = new String(Files.readAllBytes(Paths.get(responseFilename)), ApplicationConstants.CHAR_ENCODING);
			} catch (IOException e) {
				httpResponse = "Response file not found!";
			}
		} else {
			httpResponse = exchange.getRequestMethod() + " is not allowed on "+contextPath;
		}

		return httpResponse;
	}

}
