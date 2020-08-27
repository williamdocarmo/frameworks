package com.parserdemo.sax;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		InputStream inputStream = ClassLoader.getSystemResourceAsStream("input.xml");
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		saxParserFactory.setNamespaceAware(true);
		SAXParser saxParser = saxParserFactory.newSAXParser();
		saxParser.parse(inputStream, new RequestSAXHandler());
	}

}
