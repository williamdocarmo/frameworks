package com.soap.client.mobilewebservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;

import com.soap.client.common.SOAPClientHandler;
import com.soap.client.mobilewebservice.clientgen.CreateSubscriberSecure;
import com.soap.client.mobilewebservice.clientgen.CreateSubscriberSecureResponse;
import com.soap.client.mobilewebservice.clientgen.GetSecureToken;
import com.soap.client.mobilewebservice.clientgen.GetSecureTokenResponse;
import com.soap.client.mobilewebservice.clientgen.MobileService;
import com.soap.client.mobilewebservice.clientgen.MobileSubscriptionException_Exception;
import com.soap.client.mobilewebservice.clientgen.MobileWebService;
import com.soap.client.mobilewebservice.clientgen.SecurityDetails;
import com.soap.client.mobilewebservice.clientgen.SecurityException_Exception;
import com.soap.client.mobilewebservice.clientgen.SubscriberData;

//Implementation: MobileWebService
public class Client {
	
	private static final String ENDPOINT_SERVICE = "http://localhost:10001/SoapWS/Core/Mobile";
	private static final String ENDPOINT_SERVICE_PROVIDER_MESSAGE = "http://localhost:10001/SoapWS/Provider/Message";
	private static final String ENDPOINT_SERVICE_PROVIDER_SOURCE = "http://localhost:10001/SoapWS/Provider/Source";
	
	private static MobileService port;
	
	public static void main(String[] args) throws MalformedURLException, MobileSubscriptionException_Exception, SecurityException_Exception {
		MobileWebService service = new MobileWebService(new URL(ENDPOINT_SERVICE_PROVIDER_MESSAGE));
		service.setHandlerResolver(new HandlerResolver() {
			
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> handlers = new ArrayList<>();
				handlers.add(new SOAPClientHandler());
				return handlers;
			}
		});
		MobileService port = service.getMobilePort();
		BindingProvider bindingProvider = (BindingProvider) port;
		Map<String, Object> requestContext = bindingProvider.getRequestContext();
		requestContext.put(BindingProvider.USERNAME_PROPERTY, "myusername");
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, "mypassword");
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("username", Collections.singletonList("heisenberg"));
        headers.put("secure_token", Collections.singletonList("secure321"));
        requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		Client.port = port;
		operate();
	}
	
	private static void operate() throws MobileSubscriptionException_Exception, SecurityException_Exception {
		greet();
		// greetUser();
		// countBackground();
		// createSubscriber();
		// createSubscriberSecure();
		// calculateToken();
		// throwException();
		// getAllMobileSubcribers();
		// deleteSubscriber();
		// getSubscriberByMsisdn();
	}

	private static void greet() {
		String greetResponse = port.greet("Santanu");
		System.out.println(greetResponse);
	}
	
	private static void greetUser() {
		String greetResponse = port.greetUser("Santanu");
		System.out.println(greetResponse);
	}
	
	private static void countBackground() {
		port.countAsync(10);
		System.out.println("Done!");
	}
	
	private static void createSubscriber() throws MobileSubscriptionException_Exception {
		SubscriberData createSubscriberRequest = new SubscriberData();
		createSubscriberRequest.setBillCycle(30);
		createSubscriberRequest.setConnectionStartDate(null);
		createSubscriberRequest.setCustomer("CSID");
		createSubscriberRequest.setPhoneNumber("9903123499");
		port.createSubscriber(createSubscriberRequest);
	}
	
	private static void createSubscriberSecure() throws MobileSubscriptionException_Exception, SecurityException_Exception {
		SubscriberData subscriberData = new SubscriberData();
		subscriberData.setBillCycle(30);
		subscriberData.setConnectionStartDate(null);
		subscriberData.setCustomer("CSID");
		subscriberData.setPhoneNumber("9903123499");
		CreateSubscriberSecure createSubscriberSecure = new CreateSubscriberSecure();
		createSubscriberSecure.setCreateSubscriberSecureRequest(subscriberData);
		SecurityDetails credentials = new SecurityDetails();
		credentials.setUsername("secure_user");
		credentials.setPassword("pword");
		CreateSubscriberSecureResponse response = port.createSubscriberSecure(createSubscriberSecure, credentials);
		System.out.println(response);
	}
	
	private static void calculateToken() {
		GetSecureToken token = new GetSecureToken();
		token.setRandomText("Free Text");
		Holder<String> username = new Holder<>();
		username.value = "SantanuB";
		Holder<String> tokenValue = new Holder<>();
		GetSecureTokenResponse response = port.getSecureToken(token, username, "secure password", tokenValue);
		System.out.println(response.getClass());
		System.out.println("Token Value: "+tokenValue.value);
	}
	
	private static void throwException() throws MobileSubscriptionException_Exception {
		try{
			port.throwError();
		} catch (Exception e) {
			if (e instanceof MobileSubscriptionException_Exception) {
				MobileSubscriptionException_Exception exc = (MobileSubscriptionException_Exception) e;
				System.out.println(exc.getFaultInfo());
			}
		}
	}
	
	private static void getAllMobileSubcribers() {
		List<SubscriberData> subscribers = port.getAllSubscribers();
		for (SubscriberData subscriber : subscribers) {
			System.out.println(subscriber.getPhoneNumber());
		}
		
	}
	
	private static void getSubscriberByMsisdn() {
		SubscriberData subscriber = port.findSubscriber("917003446819");
		System.out.println(subscriber.getOffer());
	}
	
	public static void deleteSubscriber() {
		port.deleteSubscriber("917003446819");
	}


} 
