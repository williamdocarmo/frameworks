package com.parserdemo.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RequestSAXHandler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument():::");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument():::");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("startElement():localName::"+localName);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("endElement():::");
	}
	
}
