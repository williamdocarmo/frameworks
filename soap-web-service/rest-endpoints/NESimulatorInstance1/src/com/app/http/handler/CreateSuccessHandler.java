package com.app.http.handler;

import java.io.IOException;
import java.io.OutputStream;

import com.app.http.HttpUtils;
import com.app.utils.ApplicationConstants;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class CreateSuccessHandler implements HttpHandler {
	
	private static CreateSuccessHandler handler;
	
	private CreateSuccessHandler() {}
	
	protected static CreateSuccessHandler getInstance(){
		if(null==handler)
			handler = new CreateSuccessHandler();
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