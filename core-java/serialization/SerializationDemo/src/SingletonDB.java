import java.io.Serializable;

public class SingletonDB implements Serializable {

	private static SingletonDB instance;

	private SingletonDB() {
		if (null != instance) {
			throw new RuntimeException("Use getInstance to create Instance");
		}
	}

	public static SingletonDB getInstance() {

		if (instance == null) {
			synchronized (SingletonDB.class) {
				if (instance == null) {
					instance = new SingletonDB();
				}
			}
		}
		return instance;
	}
	
	protected Object readResolve() {
		return instance;
	}

}
