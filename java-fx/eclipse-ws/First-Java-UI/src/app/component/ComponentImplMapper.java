package app.component;

import java.util.HashMap;

public class ComponentImplMapper {
	
	private static HashMap<String, String> components;
	
	static {
		setComponentImplMapper();
	}

	private static void setComponentImplMapper() {
		components = new HashMap<>();
		components.put(UIComponent.BUTTON_HELLO_WORLD, "app.component.core.ButtonHelloWorld");
	}
	
	public static String getComponentImpl(String componentName) {
		return components.get(componentName);
	}

}
