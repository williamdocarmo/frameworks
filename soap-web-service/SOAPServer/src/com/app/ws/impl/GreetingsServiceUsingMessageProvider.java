package com.app.ws.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.Addressing;

import org.w3c.dom.Document;

import com.app.util.SOAPUtils;

@WebServiceProvider(wsdlLocation = "Greetings.wsdl", portName = "GreetingsPortName", serviceName = "GreetingsService", targetNamespace = "http://com.app.greetings/user")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
@ServiceMode(Mode.MESSAGE)
public class GreetingsServiceUsingMessageProvider implements Provider<SOAPMessage> {

	@Resource
	private WebServiceContext wsContext;

	@Override
	public SOAPMessage invoke(SOAPMessage message) {
		String operation = wsContext.getMessageContext().get(MessageContext.WSDL_OPERATION).toString();
		System.out.println("Invoked Operation: "+operation);
		Document body = null;
		body = SOAPUtils.messageBodyToDocument(message.getSOAPPart());
		System.out.println("Complete Request: \n"+SOAPUtils.nodeToString(body));
		return getResponseMessage();
	}

	private SOAPMessage getResponseMessage() {
		SOAPMessage request = null;
		try {
			InputStream is = new ByteArrayInputStream(Files.readAllBytes(Paths.get("resp.xml")));
			request = MessageFactory.newInstance().createMessage(null, is);
		} catch (IOException | SOAPException e) {
			e.printStackTrace();
		}
		return request;
	}

}
