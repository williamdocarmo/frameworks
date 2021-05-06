
public interface MyInterface {
	
	public void add();
	
	public default void show() {
		System.out.println("Show is in interface1");
	}

}
