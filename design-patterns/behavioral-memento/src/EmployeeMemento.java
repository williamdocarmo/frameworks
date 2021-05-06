
public class EmployeeMemento {

	private String empName;

	private String phoneNumber;

	public EmployeeMemento() {
		super();
	}

	public EmployeeMemento(String empName, String phoneNumber) {
		super();
		this.empName = empName;
		this.phoneNumber = phoneNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String toString() {
		return "EmployeeMemento [empName=" + empName + ", phoneNumber=" + phoneNumber + "]";
	}

}
