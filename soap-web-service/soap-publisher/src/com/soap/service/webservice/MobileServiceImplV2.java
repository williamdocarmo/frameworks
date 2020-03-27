package com.soap.service.webservice;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.soap.service.sei.MobileService;
import com.soap.util.ApplicationDB;
import com.soap.util.MobileSubscriptionException;
import com.soap.util.SOAPUtils;
import com.soap.util.SecurityException;
import com.soap.util.Validator;
import com.soap.vo.SecurityDetails;
import com.soap.vo.SubscriberData;

@WebService(endpointInterface = "com.soap.service.sei.MobileService")
public class MobileServiceImplV2 implements MobileService {

	@Resource
	public WebServiceContext wsContext;

	public String greet(String username) {
		return "Hello, " + username;
	}

	@Override
	public String greetPerson(String username) {
		return "Hello, " + username;
	}

	@Override
	public String greetPerson2(String username) {
		return "Hello, " + username;
	}

	@Override
	public void countBackground(int countTill) {
		for (int i = 1; i <= countTill; i++) {
			System.out.println("Counting Now: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public void createMobileSubcriber(SubscriberData subscriber) throws MobileSubscriptionException {
		Validator.validateSubscriber(subscriber);
		ApplicationDB.createSubscriber(subscriber);
	}

	@Override
	public void createMobileSubcriberSecure(SubscriberData subscriber, SecurityDetails secureData)
			throws MobileSubscriptionException, SecurityException {
		Validator.validateSecurity(secureData);
		Validator.validateSubscriber(subscriber);
		ApplicationDB.createSubscriber(subscriber);
	}

	@Override
	public void calculateToken(Holder<String> username, String password, Holder<String> token, String freeText) {
		System.out.println(wsContext.getMessageContext().get(SOAPMessageContext.WSDL_OPERATION));
		SOAPUtils.printMessageContext(wsContext.getMessageContext());
		System.out.println("Username: " + username.value);
		System.out.println("Password: " + password);
		token.value = String.valueOf(username.hashCode()) + String.valueOf(password.hashCode());
	}

	@Override
	public void throwException() throws MobileSubscriptionException {
		throw new MobileSubscriptionException(99, "Custom Error Message");
	}

	@Override
	public List<SubscriberData> getAllMobileSubcribers() {
		return ApplicationDB.getSubscribers();
	}

	@Override
	public SubscriberData getSubscriberByMsisdn(String msisdn) {
		return ApplicationDB.getSubscriber(msisdn);
	}

	@Override
	public void deleteSubscriber(String msisdn) {
		ApplicationDB.deleteSubscriber(msisdn);
	}

	@Override
	public SubscriberData getDummySubscriber() {
		return ApplicationDB.getDummySubscriber();
	}

}
