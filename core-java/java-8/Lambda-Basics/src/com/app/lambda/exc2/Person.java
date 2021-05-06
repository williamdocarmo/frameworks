package com.app.lambda.exc2;

public class Person {
	
	private String personId;
	
	private String personName;
	
	private String personAddress;
	
	private int personAge;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonAddress() {
		return personAddress;
	}

	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String personId, String personName, String personAddress, int personAge) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAddress = personAddress;
		this.personAge = personAge;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personAddress=" + personAddress
				+ ", personAge=" + personAge + "]";
	}
	
}
