package app.scene;

import app.component.UIComponent;
import app.component.UIComponentFactory;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class HomePageScene implements ApplicationScene {

	@Override
	public Scene getScene() {
		StackPane root = new StackPane();
		root.getChildren().add(UIComponentFactory.getFactory().getComponent(UIComponent.BUTTON_HELLO_WORLD));
		return new Scene(root, 300, 250);
	}
	

}
