package UIControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.text.View;

//import UIFiles;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class DoctorController implements Initializable {
	
	 @FXML
	    private ComboBox doctorOPMenue;

	 @FXML
	    private BorderPane operationScreenShower;
;

	    @FXML
	    void signOutFunc(ActionEvent event) throws IOException {
    		operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("LoginView.fxml")));
	    	

	    }
	    @FXML
	    void docOPSelected(ActionEvent event) throws IOException {
	    	String opChosen = doctorOPMenue.getSelectionModel().getSelectedItem().toString();
	    	
	    	if(opChosen=="Get patient Medical History")
	    		operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("patientMedicalHistory.fxml")));
	    	else if(opChosen=="Edit patient Medical History")
	    		operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("EditPatientMedicalHistory.fxml")));
	    		else if(opChosen=="Display schedule")

	    			operationScreenShower.setCenter(FXMLLoader.load(getClass().getResource("displaySchedule.fxml")));
	    }
	    public void initialize(URL url,ResourceBundle rb) {
			doctorOPMenue.setItems(FXCollections.observableArrayList("Get patient Medical History","Edit patient Medical History","Display schedule"));
			}

}
