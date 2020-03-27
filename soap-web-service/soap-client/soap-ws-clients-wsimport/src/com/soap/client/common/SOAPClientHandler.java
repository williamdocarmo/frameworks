package com.soap.client.common;

import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;


public class SOAPClientHandler implements SOAPHandler<SOAPMessageContext> {

	String headerUsername = "";
	String headerPassword = "";

	@Override
	public boolean handleMessage(SOAPMessageContext ctx) {
		SOAPMessage message = ctx.getMessage();
		try {
			boolean incoming = !(Boolean) ctx.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if (incoming) {
				// SOAP Property Analysis
				Set<String> keyset = ctx.keySet();
				System.out.println("Operation: " + ctx.get(SOAPMessageContext.WSDL_OPERATION));
				System.out.println("----------SOAP Property Analysis----------");
				for (String key : keyset) {
					System.out.println("Key: " + key + " ::: " + "Value: " + ctx.get(key));
				}
				System.out.println("----------------------------");
			}

			Source sc = message.getSOAPPart().getContent();
			StreamResult result = new StreamResult(System.out);
			if (incoming) {
				System.out.println("----------Response----------");
			}
			if (!incoming) {
				System.out.println("----------Request----------");
			}
			SOAPUtils.getTransformer().transform(sc, result);
			System.out.println("----------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void close(MessageContext arg0) {
		System.out.println("Calling the Close Method");
	}

	@Override
	public boolean handleFault(SOAPMessageContext ctx) {
		boolean incoming = !(Boolean) ctx.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
		if (!incoming) {
			System.out.println("----------Fault----------");
			SOAPMessage message = ctx.getMessage();
			Source sc = null;
			try {
				sc = message.getSOAPPart().getContent();
				StreamResult result = new StreamResult(System.out);
				SOAPUtils.getTransformer().transform(sc, result);
			} catch (TransformerException | SOAPException e) {
				e.printStackTrace();
			}
			System.out.println("----------------------------");
		}

		return false;
	}

	@Override
	public Set<QName> getHeaders() {
		return Collections.emptySet();
	}

}
