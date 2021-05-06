import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Application {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		serializationDemo();
		
		singletonSerializationDemo();
	}

	private static void serializationDemo() throws IOException, ClassNotFoundException {
		Employee originalInstance = new Employee("Santanu", "Kolkata", "9903123499");
		serialize(originalInstance);
		Employee deserializedInstance = deserialize(Employee.class);
		System.out.println(deserializedInstance);
		System.out.println("Are they same object:: "+(originalInstance == deserializedInstance));
	}
	
	public static <T> void serialize(T obj) throws IOException {
		FileOutputStream fos = new FileOutputStream("./employee.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}
	
	public static <T> T deserialize(Class<T> clazz) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("./employee.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		T obj = (T) ois.readObject();
		ois.close();
		return obj;
	}
	
	private static void singletonSerializationDemo() throws IOException, ClassNotFoundException {
		SingletonDB originalInstance = SingletonDB.getInstance();
		FileOutputStream fos = new FileOutputStream("./singleton.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(originalInstance);
		oos.close();
		
		FileInputStream fis = new FileInputStream("./singleton.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		SingletonDB deserializedInstance = (SingletonDB) ois.readObject();
		ois.close();
		
		System.out.println("Are they same object:: "+(originalInstance == deserializedInstance));
	}

}
