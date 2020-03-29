package com.app.main;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.app.libclasses.ServerContext;

public class TestFramework {
	
	private Application applicationInstance;
	
	private HashMap<String, String> requestMap;
	private HashMap<String, String> responseMap;
	
	@Before
	public void setup() throws IllegalAccessException {
		populateRequestMap();
		populateResponseMap();
		applicationInstance = new Application();
		ServerContext context = mock(ServerContext.class);
		// when(context.executeServerOperation(any(String.class), any(String.class))).thenReturn("Operation Executed in Mock Lib Class with argument: Request Value");
		when(context.executeServerOperation(any(String.class))).thenAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				String request = (String) invocation.getArguments()[0];
				String command = request.split(":")[0];
				return responseMap.get(command);
			}
		});
		ServerHandler.getInstance().setServerContext(context);
	}
	
	private void populateRequestMap() {
		requestMap = new HashMap<String, String>();
		requestMap.put("testExecuteCreate", "CreateSubscriber.xml");
	}
	
	private void populateResponseMap() {
		responseMap = new HashMap<String, String>();
		responseMap.put("CREATE", "CREATE:SUCCESSFUL");
		responseMap.put("DELETE", "DELETE:SUCCESSFUL");
		responseMap.put("GET", "GET:SUCCESSFUL");
	}

	public void executeTestcase(String testcaseName) throws SAXException, IOException, ParserConfigurationException, IllegalAccessException {
		String requestFile = requestMap.get(testcaseName);
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("src/test/resources/"+requestFile);
		String response = "";
		boolean isException = false;
		try{
			response = applicationInstance.execute(document);
			System.out.println("Response "+response);
		} catch (Exception e) {
			isException = true;
		}
		if (testcaseName.endsWith("Failed")) {
			assertTrue(isException);
		} else {
			assertTrue(response.contains("SUCCESSFUL"));
		}
	}
	
	public void analyzeMockito() {
	}

}
