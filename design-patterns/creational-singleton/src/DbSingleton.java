
public class DbSingleton {

	private static volatile DbSingleton instance;

	private DbSingleton() {
		if (instance != null) {
			throw new RuntimeException("Use getInstance() Method");
		}
	}

	public static DbSingleton getInstance() {
		if (instance == null) {
			synchronized (DbSingleton.class) {
				if (instance == null) {
					instance = new DbSingleton();
				}
			}
		}
		return instance;
	}

	protected Object readResolve() {
		return instance;
	}

}
