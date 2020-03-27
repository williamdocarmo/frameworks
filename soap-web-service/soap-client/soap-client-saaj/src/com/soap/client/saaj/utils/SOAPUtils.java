package com.soap.client.saaj.utils;

import java.io.StringWriter;

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

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class SOAPUtils {

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

}
