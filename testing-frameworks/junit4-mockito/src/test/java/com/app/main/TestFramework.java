package com.app.main;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.w3c.dom.Document;

import com.app.libclasses.ServerContext;

public class TestFramework {
	
	private Application applicationInstance;
	
	private HashMap<String, String> clientRequestMap;
	private HashMap<String, String> serverResponseMap;
	
	@Before
	public void setup() throws IllegalAccessException {
		populateRequestMap();
		populateResponseMap();
		applicationInstance = new Application();
		ServerContext context = mock(ServerContext.class);
		// when(context.executeServerOperation(any(String.class), any(String.class))).thenReturn("Operation Executed in Mock Object");
		when(context.executeServerOperation(anyString())).thenAnswer(
			new Answer<String>() {
			public String answer(InvocationOnMock invocation) throws Throwable {
				String request = (String) invocation.getArguments()[0];
				String command = request.split(":")[0];
				return serverResponseMap.get(command);
			}
		});
		ServerHandler.getInstance().setServerContext(context);
	}
	
	private void populateRequestMap() {
		clientRequestMap = new HashMap<String, String>();
		clientRequestMap.put("testExecuteCreate", "CreateSubscriber.xml");
		clientRequestMap.put("testExecuteDelete", "DeleteSubscriber.xml");
		clientRequestMap.put("testExecuteGet", "GetSubscriber.xml");
	}
	
	private void populateResponseMap() {
		serverResponseMap = new HashMap<String, String>();
		serverResponseMap.put("CREATE", "CREATE:SUCCESSFUL");
		serverResponseMap.put("DELETE", "DELETE:SUCCESSFUL");
		serverResponseMap.put("GET", "GET:SUCCESSFUL");
	}

	public void executeTestcase(String testcaseName, String expected) throws Exception {
		String requestFile = clientRequestMap.get(testcaseName);
		Document document = parseDocument(getClass().getClassLoader().getResourceAsStream(requestFile));
		String response = applicationInstance.execute(document);
		System.out.println("Response: "+response);
		assertEquals(expected, response);
	}
	
	public void analyzeMockito() {
	}
	
	public static Document parseDocument(InputStream inputStream) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setIgnoringElementContentWhitespace(true);
		return factory.newDocumentBuilder().parse(inputStream);
	}

}
