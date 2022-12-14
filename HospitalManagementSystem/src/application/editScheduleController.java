package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;

public class editScheduleController implements Initializable {
	@FXML
	private AnchorPane operationScreenShower;
	@FXML
	private Button confirmbtn;
	@FXML
	private ComboBox doctorCombBox;
	@FXML
	private ComboBox dateCombBox;
	@FXML
	private ComboBox timeCombBox;
	@FXML
	private Label errorLabel;
	
	   SystemManager sys = SystemManager.Singleton();

	// Event Listener on Button[#confirmbtn].onAction
	@FXML
	public void confirmFunction(ActionEvent event) {
		String doc=doctorCombBox.getSelectionModel().getSelectedItem().toString();
		String date=dateCombBox.getSelectionModel().getSelectedItem().toString();
		String time=timeCombBox.getSelectionModel().getSelectedItem().toString();
		if(date!=null && time!=null && doc!=null)
		sys.SecertaryEditScedule(time, date, doc);
		else 
			errorLabel.setText("please fill all boxes");
	}
	// Event Listener on ComboBox[#doctorCombBox].onAction
	@FXML
	public void doctorListFunc(ActionEvent event) {
		
	}
	// Event Listener on ComboBox[#dateCombBox].onAction
	@FXML
	public void dateListFunc(ActionEvent event) {
		String doc=doctorCombBox.getSelectionModel().getSelectedItem().toString();
		String date=dateCombBox.getSelectionModel().getSelectedItem().toString();
		if(doc!=null &&date!=null) {
			
			timeCombBox.setItems( FXCollections.observableArrayList(sys.DisplaySchedule(doc, date)));
			
		}else {
			errorLabel.setText("please fill doctor and date boxes");
		}

	}
	// Event Listener on ComboBox[#timeCombBox].onAction
	@FXML
	public void timeListFunc(ActionEvent event) {
			}
	
	public void initialize(URL url,ResourceBundle rb) {
		
	//	ObservableList<String>list=FXCollections.observableArrayList(sys.docNamesList(sys.getDoctors()));
		
		doctorCombBox.setItems(FXCollections.observableArrayList(sys.docNamesList(sys.getDoctors())));
		dateCombBox.setItems(FXCollections.observableArrayList("Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"));
		
		
		
	}
}
