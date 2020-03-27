package com.app.http.handler;

import java.io.IOException;
import java.io.OutputStream;

import com.app.http.HttpUtils;
import com.app.utils.ApplicationConstants;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Cai3gSessionHandler implements HttpHandler {
	
	private static Cai3gSessionHandler handler;
	
	private Cai3gSessionHandler() {}
	
	protected static Cai3gSessionHandler getInstance(){
		if(null==handler)
			handler = new Cai3gSessionHandler();
		return handler;
	}
	
    @Override
    public void handle(HttpExchange t) throws IOException {
    	HttpUtils.logRequest(t);
    	String httpResponse = HttpUtils.getResponseString(t);
    	if(t.getRequestMethod().equals(ApplicationConstants.HTTP_METHOD_POST)){
    		t.sendResponseHeaders(200, httpResponse.length());
    	}
        OutputStream os = t.getResponseBody();
        os.write(httpResponse.getBytes());
        os.close();
    }
}
