package com.model.vo;

import java.io.Serializable;

public class PersonData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private int age;

	private long employeeId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	public PersonData(){
		
	}
	

	public PersonData(String firstName, String lastName, int age,
			long employeeId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "PersonData [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", employeeId=" + employeeId + "]";
	}

}
