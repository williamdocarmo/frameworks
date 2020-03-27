package com.xml.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLReader {

	public static void main(String[] args) {
		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Test.xml");
			System.out.println(document.getDocumentElement().getNodeName());
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		

	}

}
