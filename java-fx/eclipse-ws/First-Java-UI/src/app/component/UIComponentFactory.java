package app.component;

import javafx.scene.Node;

@SuppressWarnings("unchecked")
public class UIComponentFactory {
	
	private static UIComponentFactory uiComponentFactory;
	
	private UIComponentFactory() {}
	
	public static UIComponentFactory getFactory () {
		if (null == uiComponentFactory)
			uiComponentFactory = new UIComponentFactory();
		return uiComponentFactory;
	}
	
	public Node getComponent (String componentName) {
		Node component = null;
		String componentImpl = ComponentImplMapper.getComponentImpl(componentName);
		Class<UIComponent> implClass;
		try {
			implClass = (Class<UIComponent>) Class.forName(componentImpl);
			component = implClass.newInstance().createComponent();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return component;
	}

}
