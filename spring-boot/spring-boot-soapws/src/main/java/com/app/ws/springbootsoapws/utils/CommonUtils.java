package com.app.ws.springbootsoapws.utils;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

public class CommonUtils {

	private static TransformerFactory transformerFactory;

	public static Transformer getTransformer(String xslFile) throws TransformerConfigurationException {
		Transformer transformer = getTransformerFactory().newTransformer();
		if (null != xslFile) {
			transformer = getTransformerFactory().newTransformer(new StreamSource(xslFile));
		}
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
		return transformer;
	}

	private static TransformerFactory getTransformerFactory() {
		if (null == transformerFactory) {
			transformerFactory = TransformerFactory.newInstance();
		}
		return transformerFactory;
	}

}
