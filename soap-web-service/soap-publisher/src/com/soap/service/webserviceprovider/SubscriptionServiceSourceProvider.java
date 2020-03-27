package com.soap.service.webserviceprovider;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Document;

import com.soap.util.ApplicationDB;
import com.soap.util.SOAPUtils;

@WebServiceProvider(wsdlLocation = "Mobile.wsdl", portName = "MobilePort", serviceName = "MobileWebService", targetNamespace = "http://webservice.service.soap.com/")
@ServiceMode(Mode.PAYLOAD)
@HandlerChain(file = "SOAPMessageHandlerConfiguration.xml")
public class SubscriptionServiceSourceProvider implements Provider<Source> {
	
	@Resource
	WebServiceContext wsContext;

	@PostConstruct
	private void construct() {
		System.out.println("Constructing Systems");
		ApplicationDB.getDummySubscriber();
	}
	
	public Source invoke(final Source inRequestMessage) {
		System.out.println("Invoked");
		String operation = wsContext.getMessageContext().get(SOAPMessageContext.WSDL_OPERATION).toString();
		if (!operation.equals("{http://webservice.service.soap.com/}greet"))
			throw new RuntimeException("Operation Not Supported!");
		Document requestDocument = SOAPUtils.sourceToDocument(inRequestMessage);
		String requestString = SOAPUtils.nodeToString(requestDocument);
		System.out.println(requestString);
		try {
			return getResponseSource();
		} catch (IOException e) {
			return null;
		}
	}
	
	private Source getResponseSource() throws IOException {
		String responseContent = new String(Files.readAllBytes(Paths.get("resp.xml")));
		return new StreamSource(new StringReader(responseContent));
		
	}
}