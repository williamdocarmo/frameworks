package com.app.client.subscriber;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;

import com.app.client.SOAPClientHandler;
import com.app.client.stubs.subscriber.AuthenticationData;
import com.app.client.stubs.subscriber.DeleteMobileSubscriber;
import com.app.client.stubs.subscriber.PerformBatchOperation;
import com.app.client.stubs.subscriber.Subscriber;
import com.app.client.stubs.subscriber.SubscriberMobileService;
import com.app.client.stubs.subscriber.SubscriberNotFoundException;
import com.app.client.stubs.subscriber.SubscriberNotFoundException_Exception;
import com.app.client.stubs.subscriber.SubscriberService;

public class SubscriberManagementClient {
	
	private static String ENDPOINT = "http://localhost:9090/SubscriberManagement";
	
	private SubscriberService port = null;
	
	public void test() {
		try{
			initializePort();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// createMobileSubscriber();
		
		// deleteMobileSubscriber();
		
		// getAllMobileSubscribers();
		
		// getMobileSubscriberByIMSI();
		
		// getMobileSubscriberByMSISDN();
		
		performBatchOperation();
	}

	private void initializePort() throws MalformedURLException {
		SubscriberMobileService service = new SubscriberMobileService(new URL(ENDPOINT));
		service.setHandlerResolver(new HandlerResolver() {
			
			@Override
			public List<Handler> getHandlerChain(PortInfo portInfo) {
				List<Handler> handlers = new ArrayList<>();
				handlers.add(new SOAPClientHandler());
				return handlers;
			}
		});
		SubscriberService port = service.getSubscriberPort();
		
		BindingProvider bindingProvider = (BindingProvider) port;
		Map<String, Object> requestContext = bindingProvider.getRequestContext();
		requestContext.put(BindingProvider.USERNAME_PROPERTY, "myusername");
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, "mypassword");
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("username", Collections.singletonList("heisenberg"));
        headers.put("secure_token", Collections.singletonList("secure321"));
        requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		this.port = port;
	}
	
	private void createMobileSubscriber() {
		Subscriber information = new Subscriber();
		information.setIMSI("799051234501234");
		information.setMSISDN("9830098300");
		information.setSMS("ENABLED");
		information.setVOICE2G("Only TS11");
		information.setVOLTE("Activated");
		System.out.println("Port: "+port);
		int result = port.createMobileSubscriber(information);
		
		System.out.println("Result: "+result);
	}
	
	private void deleteMobileSubscriber() {
		DeleteMobileSubscriber msisdn = new DeleteMobileSubscriber();
		msisdn.setMsisdn("9830098300");
		AuthenticationData authenticationData = new AuthenticationData();
		authenticationData.setUsername("Santanu");
		authenticationData.setPassword("Bhattacharyya");
		port.deleteMobileSubscriber(msisdn, authenticationData);
		
	}
	
	private void getAllMobileSubscribers() {
		List<Subscriber> subscribers = port.getAllMobileSubscribers();
		for (Subscriber sub : subscribers) {
			System.out.println("Subscriber: "+sub.getIMSI()+" "+sub.getMSISDN()+" "+sub.getVOICE2G()+" "+sub.getVOLTE()+" "+sub.getSMS());
		}
	}
	
	private void getMobileSubscriberByIMSI() {
		Subscriber subscriber;
		try {
			subscriber = port.getMobileSubscriberByIMSI("895000000000002");
			System.out.println("Subscriber: "+subscriber.getIMSI()+" "+subscriber.getMSISDN()+" "+subscriber.getVOICE2G()+" "+subscriber.getVOLTE()+" "+subscriber.getSMS());
		} catch (SubscriberNotFoundException_Exception e) {
			e.printStackTrace();
			SubscriberNotFoundException f = e.getFaultInfo();
			System.out.println("Exception Details: "+f.getFaultCode()+" "+f.getMessage()+" "+f.getFaultInfo());
		}
	}
	
	private void getMobileSubscriberByMSISDN() {
		Subscriber subscriber = port.getMobileSubscriberByMSISDN("9903123499");
		System.out.println("Subscriber: "+subscriber.getIMSI()+" "+subscriber.getMSISDN()+" "+subscriber.getVOICE2G()+" "+subscriber.getVOLTE()+" "+subscriber.getSMS());
	}
	
	private void performBatchOperation() {
		PerformBatchOperation request = new PerformBatchOperation();
		Subscriber s1 = new Subscriber();
		s1.setIMSI("IMSI1"); s1.setMSISDN("MSISDN1"); s1.setSMS("SMS1"); s1.setVOICE2G("Voice1"); s1.setVOLTE("VoLTE1");
		Subscriber s2 = new Subscriber();
		s2.setIMSI("IMSI2"); s2.setMSISDN("MSISDN2"); s2.setSMS("SMS2"); s2.setVOICE2G("Voice2"); s2.setVOLTE("VoLTE2");
		request.getSubscribers().add(s1);
		request.getSubscribers().add(s2);
		Holder<String> username = new Holder<String>();
		username.value = "usernamexx";
		
		Holder<String> timestamp = new Holder<String>();
		timestamp.value = new SimpleDateFormat("ddMMyyyy||hh:mm:ssSSS").format(new Date());
		
		port.performBatchOperation(request, username, "my password", timestamp);
	}

}
