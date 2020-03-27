package com.soap.service.handler;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.soap.util.SOAPUtils;

public class SOAPMessageHandler implements SOAPHandler<SOAPMessageContext> {

	String headerUsername = "";
	String headerPassword = "";

	@SuppressWarnings("unchecked")
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

				// HTTP Property Analysis
				Map<String, List<String>> headers = (Map<String, List<String>>) ctx
						.get(SOAPMessageContext.HTTP_REQUEST_HEADERS);

				if (null != headers && incoming) {
					System.out.println("----------HTTP Header Analysis----------");
					Set<String> httpKeySet = headers.keySet();
					for (String key : httpKeySet) {
						System.out.println("HTTP Header: " + key + " ==> " + headers.get(key).get(0));
					}
				}
				System.out.println("----------------------------");

				// SOAP Header Analysis
				System.out.println("----------SOAP Header Analysis----------");
				// Fetch header from request
				SOAPEnvelope envelope = ctx.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				Node headerUser = ((Element) header).getElementsByTagNameNS(SOAPUtils.NS, "user_name").item(0);
				Node headerPass = ((Element) header).getElementsByTagNameNS(SOAPUtils.NS, "pass_code").item(0);
				if (null != headerUser) {
					System.out.println("Header: " + headerUser.getLocalName() + " " + headerUser.getTextContent());
					headerUsername = headerUser.getTextContent();
				}
				if (null != headerPass) {
					System.out.println("Header: " + headerPass.getLocalName() + " " + headerPass.getTextContent());
					headerPassword = headerPass.getTextContent();
				}

				Iterator<?> it = message.getAttachments();
				AttachmentPart attachment = null;
				if (it.hasNext()) {
					attachment = ((AttachmentPart) message.getAttachments().next());
					System.out.println("------Attachment Details------");
					System.out.println("Attachment Content ID: " + attachment.getContentId());
					System.out.println("Attachment Content Type: " + attachment.getContentType());
					System.out.println("Attachment Content Size (Bytes): " + attachment.getSize());
					System.out.println("Attachment Content Class: " + attachment.getContent().getClass());
					if (attachment.getContent() instanceof BufferedImage) {
						File outputfile = new File("incoming.jpg");
						ImageIO.write((BufferedImage) attachment.getContent(), "jpg", outputfile);
					}
				}
			}

			// Adding Header to Response
			if (!incoming) {
				// Add header to response
				SOAPEnvelope envelope = ctx.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				if (header == null)
					header = envelope.addHeader();
				final SOAPElement security = header.addChildElement("Security", "wsse",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
				final SOAPElement userToken = security.addChildElement("UsernameToken", "wsse");
				userToken.addChildElement("Username", "wsse").addTextNode("abc@" + headerUsername);
				userToken.addChildElement("Password", "wsse").addTextNode("123@" + headerPassword);
			}

			Source sc = message.getSOAPPart().getContent();
			StreamResult result = new StreamResult(System.out);
			if (incoming) {
				System.out.println("----------Request----------");
			}
			if (!incoming) {
				System.out.println("----------Response----------");
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
