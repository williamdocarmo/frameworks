package app;
 
import app.scene.HomePageScene;
import javafx.application.Application;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Hello World!");
    	primaryStage.setScene(new HomePageScene().getScene());
    	primaryStage.show();
    }
    
    
}