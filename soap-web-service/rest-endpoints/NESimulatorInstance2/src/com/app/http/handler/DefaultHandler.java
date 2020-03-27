package com.app.http.handler;

import java.io.IOException;
import java.io.OutputStream;

import com.app.http.HttpUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class DefaultHandler implements HttpHandler {

	private static DefaultHandler handler;

	private DefaultHandler() {}

	protected static DefaultHandler getInstance() {
		if (null == handler)
			handler = new DefaultHandler();
		return handler;
	}

	@Override
	public void handle(HttpExchange t) throws IOException {
		HttpUtils.logRequest(t);
		String httpResponse = HttpUtils.getResponseString(t);
		t.sendResponseHeaders(200, httpResponse.length());
		OutputStream os = t.getResponseBody();
		os.write(httpResponse.getBytes());
		os.close();
	}
}
