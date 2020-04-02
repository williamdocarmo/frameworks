package com.jaxb.app.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EmployeeDetails", namespace = Employee.NS)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType (namespace = Employee.NS, propOrder = {"empId", "empName", "age", "addresses"})
public class Employee {

	public static final String NS = "http://vo.app.jaxb.com";

	@XmlAttribute(name = "EmployeeId")
	private String empId;
	@XmlElement(name = "EmployeeName", namespace = Employee.NS)
	private String empName;
	@XmlElement (name = "EmployeeAge", namespace = Employee.NS)
	private int age;
	@XmlElement (name = "EmployeeAddress", namespace = Employee.NS)
	@XmlElementWrapper (name = "AddressList", namespace = Employee.NS)
	private List<Address> addresses;
	@XmlTransient //Won't Appear in the XML
	private boolean isIntern;

	public String getEmpId() {
		return this.empId;
	}

	public Employee setEmpId(String empId) {
		this.empId = empId;
		return this;
	}

	public String getEmpName() {
		return this.empName;
	}

	public Employee setEmpName(String empName) {
		this.empName = empName;
		return this;
	}

	public int getAge() {
		return this.age;
	}

	public Employee setAge(int age) {
		this.age = age;
		return this;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public Employee setAddresses(List<Address> addresses) {
		this.addresses = addresses;
		return this;
	}

	public boolean isIntern() {
		return this.isIntern;
	}

	public Employee setIntern(boolean isIntern) {
		this.isIntern = isIntern;
		return this;
	}

	public Employee() {
		super();
	}

	public Employee(String empId, String empName, int age, List<Address> addresses, boolean isIntern) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.age = age;
		this.addresses = addresses;
		this.isIntern = isIntern;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", age=" + age + ", addresses=" + addresses
				+ ", isIntern=" + isIntern + "]";
	}

}
