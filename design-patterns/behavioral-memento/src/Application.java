import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		CareTaker careTaker = new CareTaker();
		
		Employee emp = new Employee("Santanu", "Kolkata", "9903123499");
		System.out.println("Employee Before Save: "+emp);
		
		careTaker.save(emp);
		System.out.println("Employee Saved");
		
		emp.setEmpName("Santanu B");
		careTaker.save(emp);
		System.out.println("Employee After Name Changed save: "+emp);
		
		emp.setPhoneNumber("11111111");
		System.out.println("Employee After Phone Change: "+emp);
		
		careTaker.revert(emp);
		System.out.println("Employee Object Reverted to: "+emp);
		
		careTaker.revert(emp);
		System.out.println("Employee Object Again Reverted to: "+emp);
		
		
	}

}
