package com.soap.client.saaj;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.soap.client.saaj.utils.SOAPUtils;

public class SOAPAttachmentContentSender {

	private static final String IMAGE_FILE1 = "sea.jpg";
	private static final String IMAGE_FILE2 = "mountain.jpg";
	private static final String ENDPOINT = "http://localhost:10001/SoapWS/Attachment/ImageAcceptor";

	public static void main(String[] args) throws UnsupportedOperationException, SOAPException,
			ParserConfigurationException, SAXException, IOException {
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection connection = soapConnectionFactory.createConnection();

		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage();
		
		SOAPPart soapPart = getSOAPDocument(message);
		//soapPart.setContent(getSOAPDocument());

		AttachmentPart attachment1 = message.createAttachmentPart();
		attachment1.setContent(getAttachment(IMAGE_FILE1), "image/jpeg");
		attachment1.setContentId(IMAGE_FILE1);
		message.addAttachmentPart(attachment1);

		java.net.URL endpoint = new URL(ENDPOINT);

		SOAPMessage response = connection.call(message, endpoint);
		System.out.println(SOAPUtils.nodeToString(response.getSOAPPart()));
	}

	private static SOAPPart getSOAPDocument(SOAPMessage message) throws SOAPException {
		SOAPPart soapPart = message.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		SOAPBody soapBody = envelope.getBody();
		QName bodyName = new QName("http://impl.service.soap.com/", "uploadImage", "m");
		SOAPBodyElement bodyElement = soapBody.addBodyElement(bodyName);
		
		QName name = new QName("arg0");
		SOAPElement arg0 = bodyElement.addChildElement(name);
		bodyElement.addChildElement(arg0);
		
		name = new QName("billCycle");
		SOAPElement billCycle = bodyElement.addChildElement(name);
		billCycle.addTextNode("30");
		arg0.addChildElement(billCycle);
		
		name = new QName("msisdn");
		SOAPElement msisdn = bodyElement.addChildElement(name);
		msisdn.addTextNode("9903123499");
		arg0.addChildElement(msisdn);
		
		name = new QName("offer");
		SOAPElement offer = bodyElement.addChildElement(name);
		offer.addTextNode("UL-VOICE");
		arg0.addChildElement(offer);
		
		name = new QName("postpaid");
		SOAPElement postpaid = bodyElement.addChildElement(name);
		postpaid.addTextNode("true");
		arg0.addChildElement(postpaid);
		
		return soapPart;
	}
	
	private static DOMSource getSOAPDocument() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		Document document = builder.parse("Request.xml");
		DOMSource domSource = new DOMSource(document);
		return domSource;
	}

	private static Object getAttachment(String filename) throws ParserConfigurationException, SAXException, IOException {
		File file = new File(filename);
		BufferedImage image = ImageIO.read(file);
		return image;
	}

}
