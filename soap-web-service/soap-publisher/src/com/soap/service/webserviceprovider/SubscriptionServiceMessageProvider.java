package com.soap.service.webserviceprovider;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.Resource;
import javax.jws.HandlerChain;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Document;

import com.soap.util.SOAPUtils;

@WebServiceProvider(wsdlLocation = "Mobile.wsdl", portName = "MobilePort", serviceName = "MobileWebService", targetNamespace = "http://webservice.service.soap.com/")
@ServiceMode(value = Service.Mode.MESSAGE)
@HandlerChain(file = "SOAPMessageHandlerConfiguration.xml")
public class SubscriptionServiceMessageProvider implements Provider<SOAPMessage> {
	
	@Resource
	WebServiceContext wsContext;

	@Override
	public SOAPMessage invoke(SOAPMessage message) {
		String operation = wsContext.getMessageContext().get(SOAPMessageContext.WSDL_OPERATION).toString();
		operation = operation.replace("{"+SOAPUtils.NS+"}", "");
		if (!operation.equals("greet")) {
			throw new RuntimeException("Operation Not Supported!");
		}
		try {
			Document body = SOAPUtils.messageBodyToDocument(message.getSOAPBody());
			System.out.println("SOAP BODY Contains: \n"+SOAPUtils.nodeToString(body.getElementsByTagNameNS(SOAPUtils.NS, operation).item(0)));
			return getResponseMessage();
		} catch (SOAPException | IOException e) {
			throw new RuntimeException("Unknown Exception");
		}
	}
	
	private SOAPMessage getResponseMessage() throws IOException, SOAPException {
		InputStream is = new ByteArrayInputStream(Files.readAllBytes(Paths.get("resp.xml")));
		SOAPMessage request = MessageFactory.newInstance().createMessage(null, is);
		return request;
	}
	
}
