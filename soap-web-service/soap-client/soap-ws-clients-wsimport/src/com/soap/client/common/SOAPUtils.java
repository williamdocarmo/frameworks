package com.soap.client.common;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SOAPUtils {
	
	public static final String NS = "http://impl.service.soap.com/";

	private static TransformerFactory transformerFactory;

	public static Transformer getTransformer() throws TransformerConfigurationException {
		if (null == transformerFactory) {
			transformerFactory = TransformerFactory.newInstance();
		}
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		return transformer;

	}

	public static Document sourceToDocument(Source source) {
		DOMResult dom = new DOMResult();
		try {
			getTransformer().transform(source, dom);
			return (Document) dom.getNode();
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
		}
		return null;
	}

	public static Document messageBodyToDocument(Node body) {
		DOMResult dom = new DOMResult();
		DOMSource domSource = new DOMSource(body);
		try {
			getTransformer().transform(domSource, dom);
			return (Document) dom.getNode();
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
		}
		return null;
	}

	public static String nodeToString(Node node) {
		DOMSource domSource = new DOMSource(node);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		try {
			getTransformer().transform(domSource, result);
		} catch (TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}

	@SuppressWarnings("unchecked")
	public static void printMessageContext(MessageContext context) {
		try {
			SOAPMessageContext soapMessageContext = (SOAPMessageContext) context;
			boolean incoming = !(Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
			String headerUsername = null;
			String headerPassword = null;
			if (incoming) {
				// SOAP Property Analysis
				Set<String> keyset = context.keySet();
				System.out.println("Operation: " + context.get(SOAPMessageContext.WSDL_OPERATION));
				System.out.println("----------SOAP Property Analysis----------");
				for (String key : keyset) {
					System.out.println("Key: " + key + " ::: " + "Value: " + context.get(key));
				}
				System.out.println("----------------------------");

				// HTTP Property Analysis
				Map<String, List<String>> headers = (Map<String, List<String>>) context
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
				if (incoming) {
					// Fetch header from request
					SOAPEnvelope envelope = soapMessageContext.getMessage().getSOAPPart().getEnvelope();
					SOAPHeader header = envelope.getHeader();
					Node headerUser = ((Element) header).getElementsByTagNameNS(NS, "user_name").item(0);
					Node headerPass = ((Element) header).getElementsByTagNameNS(NS, "pass_code").item(0);
					if (null != headerUser) {
						System.out.println("Header: " + headerUser.getLocalName() + " " + headerUser.getTextContent());
						headerUsername = headerUser.getTextContent();
					}
					if (null != headerPass) {
						System.out.println("Header: " + headerPass.getLocalName() + " " + headerPass.getTextContent());
						headerPassword = headerPass.getTextContent();
					}
				}
			}

			// Adding Header to Response
			if (!incoming) {
				// Add header to response
				SOAPEnvelope envelope = soapMessageContext.getMessage().getSOAPPart().getEnvelope();
				SOAPHeader header = envelope.getHeader();
				if (header == null)
					header = envelope.addHeader();
				final SOAPElement security = header.addChildElement("Security", "wsse",
						"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
				final SOAPElement userToken = security.addChildElement("UsernameToken", "wsse");
				userToken.addChildElement("Username", "wsse").addTextNode("abc@" + headerUsername);
				userToken.addChildElement("Password", "wsse").addTextNode("123@" + headerPassword);
			}

			// Printing the whole message
			SOAPMessage message = soapMessageContext.getMessage();
			Iterator<?> it = message.getAttachments();
			AttachmentPart attachment = null;
			if (it.hasNext()) {
				attachment = ((AttachmentPart) message.getAttachments().next());
				System.out.print("Attachment: " + attachment.getContentId() + " " + attachment.getContentType() + "\n");
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
	}

}
