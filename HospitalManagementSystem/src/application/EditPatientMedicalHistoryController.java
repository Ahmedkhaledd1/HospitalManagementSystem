package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;

public class EditPatientMedicalHistoryController implements Initializable{
	@FXML
	private AnchorPane operationScreenShower;
	@FXML
	private Label doc_excuselbl;
	@FXML
	private Label errorLabel;
	@FXML
	private ComboBox dateMenu;
	@FXML
	private TextField diagnoseTextBox;
	@FXML
	private TextField ttreatTextBox;
	@FXML
	private Label diagnoseLabel;
	@FXML
	private Label TreatmentLabel;
	 SystemManager sys = SystemManager.Singleton();
	// Event Listener on Button.onAction
	@FXML
	public void editMedicalHisFunc(ActionEvent event) {
		String patientName=dateMenu.getSelectionModel().getSelectedItem().toString();
		if(patientName!=null&&diagnoseTextBox.getText()!=null&&ttreatTextBox.getText()!=null) {
			sys.doctorEditPatientMedicalHistory(patientName, diagnoseTextBox.getText(), ttreatTextBox.getText());
			errorLabel.setText("added succesfully");
		}
			
		else {
			errorLabel.setText("please fill the form first");
		}
	}
	// Event Listener on ComboBox[#dateMenu].onAction
	@FXML
	public void dateMenuSelect(ActionEvent event) {
		// TODO Autogenerated
	}
	
public void initialize(URL url,ResourceBundle rb) {
		
		
			dateMenu.setItems(FXCollections.observableArrayList(sys.patNamesList(sys.getPatients())));
			
			
			
		}

}
