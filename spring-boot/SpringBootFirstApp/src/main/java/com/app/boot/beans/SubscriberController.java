package com.app.boot.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@RequestMapping(path = "/subscriber")
	public Subscriber getSubscriber(@RequestParam(name = "phoneNumber", required = false) String msisdn)
			throws JsonProcessingException {
		System.out.println("Inside: getSubscriber " + msisdn);
		return Database.getSubscriber(msisdn);
	}

	@RequestMapping(path = "/subscriber", method = RequestMethod.DELETE)
	public Subscriber deleteSubscriber(@RequestParam(name = "phoneNumber", required = false) String msisdn)
			throws JsonProcessingException {
		System.out.println("Inside: deleteSubscriber " + msisdn);
		return Database.deleteSubscriber(msisdn);
	}

	@PostMapping(path = "/subscriber")
	@ResponseBody
	public Subscriber addSubscriber(@Valid @RequestBody Subscriber subscriber) throws JsonProcessingException {
		System.out.println("Inside: addSubscriber " + subscriber);
		return Database.createSubscriber("Dummy MSISDN", subscriber);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}