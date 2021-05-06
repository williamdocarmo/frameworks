package com.app.bsl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.app.dao.JdbcDaoImpl;
import com.app.dao.SubscriberDAO;
import com.app.framework.ContextHolder;
import com.app.vo.Subscriber;

public class SubscriberLogic {

	private SubscriberDAO dao() {
		return ContextHolder.getContextHolder().subscriberDao();
	}

	public int createSubscriber(Subscriber subscriber) {
		return dao().createSubscriber(subscriber);
	}

	public Subscriber getSubscriber(String msisdn) {
		List<Subscriber> subscriberList = dao().getSubscriberByMSISDN(msisdn);
		if (null == subscriberList || subscriberList.size() == 0) {
			return null;
		}
		return subscriberList.get(0);
	}

	public Subscriber getSubscriberImsi(String imsi) {
		List<Subscriber> subscriberList = dao().getSubscriberByIMSI(imsi);
		if (null == subscriberList || subscriberList.size() == 0) {
			return null;
		}
		return subscriberList.get(0);
	}

	public List<Subscriber> getAllSubscribers() {
		List<Map<String, Object>> subscriberList = dao().getAllSubscriber();
		List<Subscriber> subscribers = new ArrayList<Subscriber>();
		for (Map<String, Object> s : subscriberList) {
			Subscriber subscriber = new Subscriber(s.get("msisdn").toString(), s.get("imsi").toString(),
					s.get("voice2G").toString(), s.get("voiceLTE").toString(), s.get("SMS").toString(),
					s.get("MMS").toString(), s.get("GPRS").toString(), s.get("LTE").toString());
			subscribers.add(subscriber);
		}
		return subscribers;
	}

	public int updateSubscriber(String msisdn, String voice2G, String volte, String sms, String mms, String dataGprs,
			String dataLte) {
		return dao().updateSubscriber(msisdn, voice2G, volte, sms, mms, dataGprs, dataLte);
	}

	public int deleteSubscriber(String msisdn) {
		return dao().deleteSubscriber(msisdn);
	}

}
