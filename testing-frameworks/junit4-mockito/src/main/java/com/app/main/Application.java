package com.app.main;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Application {
	
	public String execute(Document request) throws IllegalAccessException {
		String operation = request.getDocumentElement().getNodeName();
		String msisdn = request.getFirstChild().getFirstChild().getNextSibling().getTextContent();
		String command = operation+":MSISDN="+msisdn+";";
		String response = ServerHandler.getInstance().getServerContext().executeServerOperation(command);
		return response;
		
	}

}
