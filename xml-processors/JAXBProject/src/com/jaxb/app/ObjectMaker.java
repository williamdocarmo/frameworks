package com.jaxb.app;

import java.util.ArrayList;
import java.util.List;

import com.jaxb.app.vo.Address;
import com.jaxb.app.vo.Employee;

public class ObjectMaker {
	
	public static Employee makeObject() {
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(new Address(1, "8/B Bhattacharjee Lane", "Serampore", "712201"));
		addresses.add(new Address(2, "DLF-2 IT Park", "New Town", "700156"));
		Employee employee = new Employee();
		employee.setEmpId("esnubya").setEmpName("Santanu Bhattacharyya").setIntern(false).setAge(30).setAddresses(addresses);
		return employee;
	}

}
