package com.soap.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.soap.vo.SubscriberData;

public class ApplicationDB {

	private static HashMap<String, SubscriberData> subscriberDatabase = new HashMap<>();

	public static void createSubscriber(SubscriberData subscriber) {
		subscriberDatabase.put(subscriber.getMsisdn(), subscriber);
	}

	public static SubscriberData getSubscriber(String msisdn) {
		return subscriberDatabase.get(msisdn);
	}

	public static void deleteSubscriber(String msisdn) {
		subscriberDatabase.remove(msisdn);
	}

	public static SubscriberData getDummySubscriber() {
		createSubscriber(new SubscriberData("919903123499", "VOICE-UL-DATA-2GB", 360, new Date(), true));
		createSubscriber(new SubscriberData("917003446819", "VOICE-UL-DATA-1GB", 30, new Date(), false));
		return subscriberDatabase.get("919903123499");
	}

	public static List<SubscriberData> getSubscribers() {
		ArrayList<SubscriberData> subscribers = new ArrayList<SubscriberData>();
		subscribers.addAll(subscriberDatabase.values());
		return subscribers;
	}

}
