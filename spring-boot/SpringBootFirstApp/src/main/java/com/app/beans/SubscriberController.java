package com.app.beans;

import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.db.Database;
import com.app.vo.Subscriber;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class SubscriberController {
	
	@RequestMapping("/subscriberNumbers")
	public Set<String> getAllSubscribers() throws JsonProcessingException {
		System.out.println("Inside: getAllSubscribers");
		return Database.getAllSubscriberNumbers();
	}
	
	@RequestMapping("/allsubscribers")
	public Map<String, Subscriber> getAllSubscriberData() throws JsonProcessingException {
		System.out.println("Inside: getAllSubscriberData");
		return Database.getAllSubscribers();
	}
	
	@RequestMapping(path= "/subscriber")
	public Subscriber getSubscriber(@RequestParam(name = "phoneNumber", required = false) String msisdn) throws JsonProcessingException {
		System.out.println("Inside: getSubscriber "+msisdn);
		return Database.getSubscriber(msisdn);
	}
	
	@RequestMapping(path= "/subscriber", method = RequestMethod.DELETE)
	public Subscriber deleteSubscriber(@RequestParam(name = "phoneNumber", required = false) String msisdn) throws JsonProcessingException {
		System.out.println("Inside: getSubscriber "+msisdn);
		return Database.deleteSubscriber(msisdn);
	}

}
