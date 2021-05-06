package com.app.handler;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.app.util.ServiceUtils;

@SuppressWarnings("unchecked")
public class ServiceHandler implements SOAPHandler<SOAPMessageContext> {
	
	String headerUsername = "";
	String headerPassword = "";

	@Override
	public boolean handleMessage(SOAPMessageContext ctx) {
		return handle(ctx);
	}

	private boolean handle(SOAPMessageContext ctx) {
		try {
			// MessageConext Information
			Set<String> keyset = ctx.keySet();
			System.out.println("Operation: " + ctx.get(SOAPMessageContext.WSDL_OPERATION));
			boolean incoming = !(Boolean) ctx.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if (incoming)
				for (String key : keyset) {
					System.out.println("Key: " + key + " ::: " + "Value: " + ctx.get(key));
				}

			// HTTP Headers
			Map<String, List<String>> headers = (Map<String, List<String>>) ctx.get(SOAPMessageContext.HTTP_REQUEST_HEADERS);
			if (null != headers && incoming) {
				System.out.println("----------HTTP Header Analysis----------");
				List<String> username = headers.get("username");
				List<String> secureToken = headers.get("secure_token");
				System.out.println("Username in HTTP Header: " + username);
				System.out.println("Secure Code in HTTP Header: " + secureToken);
			}
			System.out.println("----------------------------");

			// SOAP Request Headers
			System.out.println("----------SOAP Header Analysis----------");
			if (incoming) {
				SOAPEnvelope envelope = ctx.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				Node headerUser = ((Element) header).getElementsByTagName("ser:user_name").item(0);
				Node headerPass = ((Element) header).getElementsByTagName("ser:pass_code").item(0);
				if (null != headerUser) {
					System.out.println("Header: " + headerUser.getLocalName() + " " + headerUser.getTextContent());
					headerUsername = headerUser.getTextContent();
				}
				if (null != headerPass) {
					System.out.println("Header: " + headerPass.getLocalName() + " " + headerPass.getTextContent());
					headerPassword = headerPass.getTextContent();
				}

			}
			
			// SOAP Response Headers
			if (!incoming) {
				SOAPEnvelope envelope = ctx.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				if (header == null)
					header = envelope.addHeader();
				setToken(ctx.getMessage());
			}

			// SAAJ Attachments
			SOAPMessage message = ctx.getMessage();
			Iterator<?> it = message.getAttachments();
			AttachmentPart attachment = null;
			if (it.hasNext()) {
				attachment = ((AttachmentPart) message.getAttachments().next());
				System.out.print("Attachment: " + attachment.getContentId() + " " + attachment.getContentType() + "\n");
			}
			// Printing the whole message
			Source soapPart = message.getSOAPPart().getContent();
			if (incoming) {
				System.out.println("----------Request----------");
			}
			if (!incoming) {
				System.out.println("----------Response----------");
			}
			ServiceUtils.getTransformer().transform(soapPart, new StreamResult(System.out));
			System.out.println("----------------------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void close(MessageContext arg0) {
	}

	@Override
	public boolean handleFault(SOAPMessageContext ctx) {
		handle(ctx);
		return true;
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}
	
	private static final String cNODE_USRTOKEN = "UsernameToken";
	private static final String cNODE_USERNAME = "Username";
	private static final String cNODE_PASSWORD = "Password";
	private String usernameValue = "WSSE User Name";
	private String passwordValue = "WSSE Pass Word";
	
	public Element setToken(SOAPMessage soapMessage) throws SOAPException {

		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		SOAPHeader header = envelope.getHeader();

		if (header == null) {
			// no header yet, create one
			header = envelope.addHeader();
		}
		SOAPElement security = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

		Name userTokenName = envelope.createName(cNODE_USRTOKEN, "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
		SOAPElement tUserTokenElement = security.addChildElement(userTokenName);
		tUserTokenElement.removeNamespaceDeclaration("wsse");
		tUserTokenElement.addNamespaceDeclaration("wsu", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

		// user name child
		Name usernameName = envelope.createName(cNODE_USERNAME, "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
		SOAPElement tUsernameElement = tUserTokenElement.addChildElement(usernameName);
		tUsernameElement.removeNamespaceDeclaration("wsse");
		tUsernameElement.addTextNode(usernameValue);

		// password child
		Name passwordName = envelope.createName(cNODE_PASSWORD, "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
		SOAPElement tPasswordElement = tUserTokenElement.addChildElement(passwordName);
		tPasswordElement.removeNamespaceDeclaration("wsse");
		tPasswordElement.addTextNode(passwordValue);
		tPasswordElement.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
		
		return (Element) security;
	}

}
