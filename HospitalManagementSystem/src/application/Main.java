package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



import java.io.IOException;



public class Main extends Application {
	private static Stage mainStage;
	@Override
	public void start(Stage primaryStage) throws IOException {
		
			mainStage = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			primaryStage.setResizable(false);
			primaryStage.setScene(new Scene(root,688,488));
			primaryStage.setTitle("Hospital Management System");
			primaryStage.show();
			
		
	}
	
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		mainStage.getScene().setRoot(pane);
	}
	
	public static void main(String[] args) {
		launch();
	}
}
