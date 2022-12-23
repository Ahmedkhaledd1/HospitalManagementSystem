package UIFiles;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
//import UIFiles.*;

import java.io.IOException;

import UIControllers.*;

public class Main extends Application {
	private static Stage mainStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			mainStage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			primaryStage.setResizable(false);
			primaryStage.setScene(new Scene(root,688,488));
			primaryStage.setTitle("Hospital Management System");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		mainStage.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch();
	}
}
