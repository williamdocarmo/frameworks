package com.app.framework;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.app.util.ServiceUtils;

public class ServiceHandler implements SOAPHandler<SOAPMessageContext> {
	
	String headerUsername = "";
	String headerPassword = "";

	@SuppressWarnings("unchecked")
	@Override
	public boolean handleMessage(SOAPMessageContext ctx) {
		try {
			Set<String> keyset = ctx.keySet();
			System.out.println("Operation: "+ ctx.get(SOAPMessageContext.WSDL_OPERATION));
			boolean incoming = !(Boolean) ctx.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if (incoming)
				for (String key : keyset) {
					System.out.println("Key: " + key + " ::: " + "Value: "+ ctx.get(key));
				}
			
			Map<String, List<String>> headers = (Map<String, List<String>>) ctx.get(SOAPMessageContext.HTTP_REQUEST_HEADERS);
			if(null!=headers && incoming){
				System.out.println("----------HTTP Header Analysis----------");
				if(null!=headers.get("username"))
					System.out.println("Username in HTTP Header: "+headers.get("username").get(0));
				if(null!=headers.get("secure_token"))
					System.out.println("Secure Code in HTTP Header: "+headers.get("secure_token").get(0));
			}
			System.out.println("----------------------------");
			
			System.out.println("----------SOAP Header Analysis----------");
			if(incoming){
				//Fetch header from request
				SOAPEnvelope envelope = ctx.getMessage().getSOAPPart().getEnvelope();
	            SOAPHeader header = envelope.getHeader();
	            Node headerUser = ((Element)header).getElementsByTagName("user_name").item(0);
	            Node headerPass = ((Element)header).getElementsByTagName("pass_code").item(0);
	            if(null!=headerUser){
	            	System.out.println("Header: "+headerUser.getLocalName()+" "+headerUser.getTextContent());
	            	headerUsername = headerUser.getTextContent();
	            }
	            if(null!=headerPass){
	            	System.out.println("Header: "+headerPass.getNodeName()+" "+headerPass.getTextContent());
		            headerPassword = headerPass.getTextContent();
	            }
	            
	        }
			if(!incoming){
				//Add header to response
				SOAPEnvelope envelope = ctx.getMessage().getSOAPPart().getEnvelope();
	            SOAPHeader header = envelope.getHeader();
	            if (header == null)
	                header = envelope.addHeader();
	            final SOAPElement security = header.addChildElement("Security", "wsse",
	                    "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
	            final SOAPElement userToken = security.addChildElement("UsernameToken", "wsse");
	            userToken.addChildElement("Username", "wsse").addTextNode("abc@"+headerUsername);
	            userToken.addChildElement("Password", "wsse").addTextNode("123@"+headerPassword);
			}
			
			//Printing the whole message
			SOAPMessage message = ctx.getMessage();
			Iterator<?> it = message.getAttachments();
			AttachmentPart attachment = null;
			if (it.hasNext()){
				attachment = ((AttachmentPart)message.getAttachments().next());
				System.out.print("Attachment: " + attachment.getContentId() +" "+ attachment.getContentType()+"\n");
			}
			Source sc = message.getSOAPPart().getContent();
			StreamResult result = new StreamResult(System.out);
			if(incoming){
				System.out.println("----------Request----------");
			}
			if(!incoming){
				System.out.println("----------Response----------");
			}
			ServiceUtils.getTransformer().transform(sc, result);
			System.out.println("----------------------------");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void close(MessageContext arg0) {}

	@Override
	public boolean handleFault(SOAPMessageContext arg0) {return false;}

	@Override
	public Set<QName> getHeaders() {return null;}

}
