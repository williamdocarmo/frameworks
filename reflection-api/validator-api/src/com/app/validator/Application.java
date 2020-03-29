package com.app.validator;

public class Application {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		SubscriberData subscriber1 = new SubscriberData("41903123456789012345", "", "bs660", 257, "TRUEE", null, "255.255.255.256");
		String validatorError = ValidatorApi.validate(subscriber1);
		if (validatorError.length()>0) {
			throw new IllegalArgumentException(validatorError);
		}
		System.out.println("Validated Successfully");
	}

}
