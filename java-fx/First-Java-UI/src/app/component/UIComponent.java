package app.component;

import javafx.scene.Node;

public interface UIComponent {
	
	public static final String BUTTON_HELLO_WORLD = "BUTTON_HELLO WORLD";
	
	public Node createComponent();

}
