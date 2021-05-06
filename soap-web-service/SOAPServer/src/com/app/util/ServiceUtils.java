package com.app.util;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

public class ServiceUtils {
	
	private static TransformerFactory transformerFactory;

	public static Transformer getTransformer() throws TransformerConfigurationException{
		if(null==transformerFactory){
			transformerFactory = TransformerFactory.newInstance();
		}
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		return transformer;
		
	}
}