package com.app.validator;

public class Application {


	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		SubscriberData deaboic = new SubscriberData();
		deaboic.setImsi("41902123456789012345"); //Does not start with 41902, so the validation will fail
		deaboic.setIsdn("9659903123499"); //ISDN should not be blank/null, so the validation will fail 
		deaboic.setBsg("bs6"); //Length should be within 1-4, so the validation will fail
		deaboic.setHlrsn(250); //Range should be with 1-256, so the validation will fail
 		deaboic.setTcsiprov("TRUE"); //TRUEE is not an allowed value, so the validation will fail
		deaboic.setOcsiprov("FALSE"); //Null check is on for OCSIPROV, so the validation will fail
		deaboic.setIpv4Address("255.255.255.255"); //IP Address is not valid and does not match the regex, so the validation will fail
		ValidatorApi.validate(deaboic); //This operation needs to be invoked for validation
		System.out.println("Validated Successfully");
		// Perform subsequent operations
	}

}
