package com.app.ws.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.AddressingFeature;
import javax.xml.ws.soap.AddressingFeature.Responses;

import com.app.db.SubscriberDB;
import com.app.exc.SubscriberNotFoundException;
import com.app.vo.AuthenticationData;
import com.app.vo.Subscriber;
import com.app.ws.SubscriberService;


@WebService(name = "SubscriberMobileServiceName", portName = "SubscriberPort", serviceName = "SubscriberMobileService", endpointInterface = "com.app.ws.SubscriberService")
@Addressing(enabled = true, required = false)
public class SubscriberServiceImpl implements SubscriberService {
	
	@Resource
	WebServiceContext webServiceContext;
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Post Construct Called");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Pre Destroy Called");
	}
	
	SubscriberDB dao = new SubscriberDB();
	
	public int createSubscriber(Subscriber subscriber) {
		return dao.createSubscriber(subscriber);
	}
	
	public Subscriber getSubscriber(String msisdn) {
		return dao.getSubscriberByMSISDN(msisdn);
	}
	
	public Subscriber getSubscriberImsi(String imsi) throws SubscriberNotFoundException {
		Subscriber subscriber = dao.getSubscriberByIMSI(imsi);
		if (subscriber == null) {
			throw new SubscriberNotFoundException(5000, "IMSI_NOT_PRESENT", "Subscriber with IMSI "+imsi+" Does Not Exist!");
		}
		return subscriber;
	}
	
	public List<Subscriber> getAllSubscribers() {
		Map<String,List<String>> headers = (Map<String, List<String>>) webServiceContext.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
		System.out.println("User Name "+headers.get("username"));
		return dao.getAllSubscriber();
	}
	
	public int updateSubscriber(String msisdn, String voice2G, String volte, String sms, String mms, String dataGprs, String dataLte) {
		return dao.updateSubscriber(msisdn, voice2G, volte, sms, dataLte);
	}
	
	public int deleteSubscriber(AuthenticationData authData, String msisdn) {
		System.out.println("Authentication Info: "+authData);
		return dao.deleteSubscriber(msisdn);
	}

	@Override
	public String performBatchOperation(List<Subscriber> subscribers, Holder<String> username, String password, Holder<String> timestamp) {
		try {
			System.out.println("Authentication Data Entered: "+username+" "+password);
			for (Subscriber sub : subscribers) dao.createSubscriber(sub);
			timestamp.value = new SimpleDateFormat("dd-MM-yyyy:hh:mm:ss.SSS").format(new Date());
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failed";
	}

}
