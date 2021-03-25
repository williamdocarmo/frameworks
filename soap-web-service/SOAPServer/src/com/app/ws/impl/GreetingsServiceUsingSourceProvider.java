package com.app.ws.impl;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
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

@WebServiceProvider (wsdlLocation = "Greetings.wsdl", portName = "GreetingsPortName", serviceName = "GreetingsService", targetNamespace = "http://com.app.greetings/user")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT, use = Use.LITERAL)
@ServiceMode(Mode.PAYLOAD)
public class GreetingsServiceUsingSourceProvider implements Provider<Source> {
	
	@Resource
	private WebServiceContext wsContext;
	
	@Override
	public Source invoke(Source requestMessage) {
		String operation = wsContext.getMessageContext().get(MessageContext.WSDL_OPERATION).toString();
		System.out.println("Invoked Operation: "+operation);
		Document requestDocument = SOAPUtils.sourceToDocument(requestMessage);
		String requestString = SOAPUtils.nodeToString(requestDocument);
		System.out.println("Complete Request: \n"+requestString);
		return getResponseSource();
	}
	
	private Source getResponseSource() {
		String responseContent = null;
		try {
			responseContent = new String(Files.readAllBytes(Paths.get("resp.xml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new StreamSource(new StringReader(responseContent));
	}

}
