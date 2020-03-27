package com.app.http.handler;

import java.io.IOException;
import java.io.OutputStream;

import com.app.http.HttpUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class JsonErrorHandler implements HttpHandler {
	
	private static JsonErrorHandler handler;
	
	private JsonErrorHandler() {}
	
	protected static JsonErrorHandler getInstance(){
		if(null==handler)
			handler = new JsonErrorHandler();
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