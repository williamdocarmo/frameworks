
public class Application {

	public static void main(String[] args) {

		DbSingleton instance1 = DbSingleton.getInstance();
		DbSingleton instance2 = DbSingleton.getInstance();

		System.out.println(instance1);
		System.out.println(instance2);

		System.out.println("Both instances are same: " + (instance1 == instance2));

	}

	private static void runtimeDemo() {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();

		Runtime anotherRuntime = Runtime.getRuntime();

		System.out.println(runtime);
		System.out.println(anotherRuntime);

		if (runtime == anotherRuntime)
			System.out.println("Both Instances are Same");
	}

}
