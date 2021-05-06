import java.io.Serializable;

public class Employee {

	private String empName;

	private String address;

	private String phoneNumber;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Employee(String empName, String address, String phoneNumber) {
		super();
		this.empName = empName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
	public EmployeeMemento save() {
		return new EmployeeMemento(empName, phoneNumber);
	}
	
	public void revert(EmployeeMemento employeeMemento) {
		this.empName = employeeMemento.getEmpName();
		this.phoneNumber = employeeMemento.getPhoneNumber();
	}

}
