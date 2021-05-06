package com.app.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.vo.Subscriber;

public class SubscriberDB {
	
	private static Map<String, Subscriber> subscribers = new HashMap<String, Subscriber>();
	
	static {
		subscribers.put("9903123499", new Subscriber("9903123499", "895000000000000", "Activated", "Deactivated", "Enabled", "Disabled"));
		subscribers.put("8584003499", new Subscriber("8584003499", "895000000000001", "Deactivated", "Enabled", "Enabled", "Activated"));
	}

	public int createSubscriber(Subscriber subscriber) {
		subscribers.put(subscriber.getMsisdn(), subscriber);
		return 0;
	}

	public Subscriber getSubscriberByMSISDN(String msisdn) {
		return subscribers.get(msisdn);
	}

	public Subscriber getSubscriberByIMSI(String imsi) {
		// TODO Auto-generated method stub
		Collection<Subscriber> subscriber = subscribers.values();
		for (Subscriber sub : subscriber) {
			if (imsi.equals(sub.getImsi())) {
				return sub;
			}
		}
		return null;
	}

	public List<Subscriber> getAllSubscriber() {
		List<Subscriber> subList = new ArrayList<Subscriber>();
		subList.addAll(subscribers.values());
		return subList;
	}

	public int updateSubscriber(String msisdn, String voice2g, String volte, String sms, String dataLte) {
		Subscriber subscriber = subscribers.get(msisdn);
		subscriber.setVoice2G(voice2g);
		subscriber.setVolte(volte);
		subscriber.setSms(sms);
		subscriber.setDataLte(dataLte);
		subscribers.put(msisdn, subscriber);
		return 0;
	}

	public int deleteSubscriber(String msisdn) {
		subscribers.remove(msisdn);
		return 0;
	}

}
