package com.app.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.app.vo.Subscriber;

public class Database {
	
	private static Map<String, Subscriber> allSubscribers;
	
	static {
		allSubscribers = new HashMap<String, Subscriber>();
		allSubscribers.put("MSISDN1", new Subscriber("enabled", "enabled", "ts21", "activated", "internet, mms", "internet, mms, volte"));
		allSubscribers.put("MSISDN2", new Subscriber("disabled", "disabled", "ts21", "disabled", "no APNs", "no APNs"));
		allSubscribers.put("MSISDN3", new Subscriber("enabled", "disabled", "ts21, ts22", "disabled", "internet", "internet"));
	}
	
	public static Subscriber createSubscriber(String msisdn, Subscriber subscriber) {
		return allSubscribers.put(msisdn, subscriber);
	}
	
	public static Set<String> getAllSubscriberNumbers() {
		return allSubscribers.keySet();
	}
	
	public static Map<String, Subscriber> getAllSubscribers() {
		return allSubscribers;
	}
	
	public static Subscriber getSubscriber(String msisdn) {
		return allSubscribers.get(msisdn);
	}
	
	public static Subscriber deleteSubscriber(String msisdn) {
		return allSubscribers.remove(msisdn);
	}

}
