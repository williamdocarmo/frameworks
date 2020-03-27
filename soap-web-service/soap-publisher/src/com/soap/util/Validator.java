package com.soap.util;

import com.soap.vo.SecurityDetails;
import com.soap.vo.SubscriberData;

public class Validator {
	
	public static void validateSecurity(SecurityDetails secureData) throws MobileSubscriptionException, SecurityException {
		if (!secureData.getUsername().equals("secure_user"))
			throw new SecurityException("Username is invalid");
	}
	
	public static void validateSubscriber(SubscriberData subscriber) throws MobileSubscriptionException {
		if (subscriber.getMsisdn().length()<10)
			throw new MobileSubscriptionException(1, "MSISDN Not Valid");
		else if (subscriber.getBillCycle()!=30 && subscriber.getBillCycle()!=90)
			throw new MobileSubscriptionException(2, "Billing Cycle Not Valid");
	}

}
