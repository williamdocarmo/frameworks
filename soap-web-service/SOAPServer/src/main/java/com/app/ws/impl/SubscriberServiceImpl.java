package com.app.ws.impl;

import java.util.List;

import com.app.bsl.SubscriberLogic;
import com.app.vo.AuthenticationData;
import com.app.vo.Subscriber;
import com.app.ws.SubscriberService;

import jakarta.jws.WebService;

@WebService(endpointInterface = "com.app.ws.SubscriberService")
public class SubscriberServiceImpl implements SubscriberService {
	
	SubscriberLogic logic = new SubscriberLogic();
	
	public int createSubscriber(Subscriber subscriber) {
		return logic.createSubscriber(subscriber);
	}
	
	public Subscriber getSubscriber(String msisdn) {
		return logic.getSubscriber(msisdn);
	}
	
	public Subscriber getSubscriberImsi(String imsi) {
		return logic.getSubscriberImsi(imsi);
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

}
