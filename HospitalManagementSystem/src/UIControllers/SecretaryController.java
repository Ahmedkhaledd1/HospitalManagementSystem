package UIControllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class SecretaryController implements Initializable {
	@FXML
    private ComboBox SecertaryOPMenue;

    @FXML
    private BorderPane operationScreenShower;

    @FXML
    void signOutFunc(ActionEvent event)throws IOException {
    	operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("LoginView.fxml")));

    }
    void seceratryOpSelected(ActionEvent event)throws IOException {
    	String opChosen = SecertaryOPMenue.getSelectionModel().getSelectedItem().toString();
    	
    	if(opChosen=="Initiate Execuse")
    		operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("initiateExcuse.fxml")));
    	else if(opChosen=="Edit patient Medical History")
    		operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("EditPatientMedicalHistory.fxml")));
    		else if(opChosen=="Display schedule")

    			operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("displaySchedule.fxml")));
    		else if(opChosen=="Add Appointment")
    			operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("AddAppointmentScreen.fxml")));
    	
    		else if(opChosen=="Edit Appointment")
    			operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("EditAppointScreen.fxml")));
    }
    public void initialize(URL url,ResourceBundle rb) {
    	
    	SecertaryOPMenue.setItems(FXCollections.observableArrayList("Display Schedule","Edit Schedule","Initiate Execuse","Add Appointment","Edit Appointment"));
    	
    	
		}
    
}
