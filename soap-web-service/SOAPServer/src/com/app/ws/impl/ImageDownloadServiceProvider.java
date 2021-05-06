package com.app.ws.impl;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MimetypesFileTypeMap;
import javax.annotation.Resource;
import javax.xml.ws.BindingType;
import javax.xml.ws.Provider;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.http.HTTPException;

import com.sun.net.httpserver.HttpExchange;

@WebServiceProvider(targetNamespace="http://attachment.service.soap.com/download")
@ServiceMode(value = javax.xml.ws.Service.Mode.MESSAGE)
@BindingType(value = HTTPBinding.HTTP_BINDING)
public final class ImageDownloadServiceProvider implements Provider<DataSource> {
	
	@Resource
	private WebServiceContext wsContext;

	@Override
	public DataSource invoke(DataSource request) {
		if (wsContext == null)
			throw new RuntimeException("dependency injection failed on wsContext");
		MessageContext msgContext = wsContext.getMessageContext();
		HttpExchange exchange = (HttpExchange) msgContext.get("com.sun.xml.ws.http.exchange");
		String filename = exchange.getRequestURI().getQuery().replace("file=", "");
		switch ((String) msgContext.get(MessageContext.HTTP_REQUEST_METHOD)) {
		case "GET":
			return doGet(filename);
		default:
			throw new HTTPException(405);
		}
	}

	private DataSource doGet(String filename) {
		FileDataSource fds = new FileDataSource(filename);
		MimetypesFileTypeMap mtftm = new MimetypesFileTypeMap();
		mtftm.addMimeTypes("image/jpeg jpg");
		fds.setFileTypeMap(mtftm);
		return fds;
	}

}