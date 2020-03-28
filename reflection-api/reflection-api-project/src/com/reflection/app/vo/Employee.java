package com.reflection.app.vo;

import java.util.List;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empDetails", namespace = "http://com/reflection/app")
@WebService(portName = "employeePort", serviceName = "employeeService")
public class Employee {
	
	private String employeeId;
	
	private String employeeName;
	
	private int age;
	
	private String designation;
	
	private List<String> address;

	public String getEmployeeId() {
		return employeeId;
	}

	public Employee setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
		return this;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public Employee setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Employee setAge(int age) {
		this.age = age;
		return this;
	}

	public String getDesignation() {
		return designation;
	}

	public Employee setDesignation(String designation) {
		this.designation = designation;
		return this;
	}

	public List<String> getAddress() {
		return address;
	}

	public Employee setAddress(List<String> address) {
		this.address = address;
		return this;
	}

	public Employee(String employeeId, String employeeName, int age, String designation, List<String> address) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.age = age;
		this.designation = designation;
		this.address = address;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", age=" + age
				+ ", designation=" + designation + ", address=" + address + "]";
	}
	
}
