package com.app.ws.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import com.app.bsl.SubscriberLogic;
import com.app.exc.SubscriberNotFoundException;
import com.app.vo.AuthenticationData;
import com.app.vo.Subscriber;
import com.app.ws.SubscriberService;

import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

@WebService(name = "SubscriberMobileServiceName", portName = "SubscriberPort", serviceName = "SubscriberMobileService", endpointInterface = "com.app.ws.SubscriberService")
public class SubscriberServiceImpl implements SubscriberService {
	
	String headerUsername = "";
	String headerPassword = "";
	
	@Resource
	WebServiceContext context;
	
	SubscriberLogic logic = new SubscriberLogic();
	
	public int createSubscriber(Subscriber subscriber) {
		return logic.createSubscriber(subscriber);
	}
	
	public Subscriber getSubscriber(String msisdn) {
		printContext();
		return logic.getSubscriber(msisdn);
	}
	
	public Subscriber getSubscriberImsi(String imsi) throws SubscriberNotFoundException {
		Subscriber subscriber = logic.getSubscriberImsi(imsi);
		if (subscriber == null) {
			throw new SubscriberNotFoundException(5000, "IMSI_NOT_PRESENT", "Subscriber with IMSI "+imsi+" Does Not Exist!");
		}
		return subscriber;
	}
	
	public List<Subscriber> getAllSubscribers() {
		return logic.getAllSubscribers();
	}
	
	public int updateSubscriber(String msisdn, String voice2G, String volte, String sms, String mms, String dataGprs, String dataLte) {
		return logic.updateSubscriber(msisdn, voice2G, volte, sms, mms, dataGprs, dataLte);
	}
	
	public int deleteSubscriber(AuthenticationData authData, String msisdn) {
		System.out.println("Authentication Info: "+authData);
		return logic.deleteSubscriber(msisdn);
	}
	
	private void printContext() {
		try {
			MessageContext ctx = context.getMessageContext();
			Set<String> keyset = ctx.keySet();
			for (String key : keyset) {
				System.out.println("Key: " + key + " ::: " + "Value: "+ ctx.get(key));
			}
			
			Map<String, List<String>> headers = (Map<String, List<String>>) ctx.get(SOAPMessageContext.HTTP_REQUEST_HEADERS);
			if(null!=headers){
				System.out.println("----------HTTP Header Analysis----------");
				if(null!=headers.get("username"))
					System.out.println("Username in HTTP Header: "+headers.get("username").get(0));
				if(null!=headers.get("secure_token"))
					System.out.println("Secure Code in HTTP Header: "+headers.get("secure_token").get(0));
			}
			System.out.println("----------------------------");
			
			System.out.println("----------SOAP Header Analysis----------");
			
			HttpServletRequest request = (HttpServletRequest) ctx.get(SOAPMessageContext.SERVLET_REQUEST);
			System.out.println("request.getContentLength() "+request.getContentLength());
			System.out.println("request.getHeaderNames() "+request.getHeader("username"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// return true;
	}	

}
