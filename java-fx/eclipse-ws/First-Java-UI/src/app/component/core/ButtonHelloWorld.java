package app.component.core;

import app.component.UIComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class ButtonHelloWorld implements UIComponent {

	@Override
	public Node createComponent() {
		Button helloWorld = new Button();
		helloWorld.setText("Say 'Hello World'");
		helloWorld.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				helloWorld.setText("Hello World!");
			}
		});
		return helloWorld;
	}


}
