package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.CheckBox;

public class EditAppointScreenController implements Initializable {
	@FXML
	private AnchorPane operationScreenShower1;
	@FXML
	private ComboBox docMenu;
	@FXML
	private Label dateLabel;
	@FXML
	private Label resTime;
	@FXML
	private ComboBox timesMenu;
	@FXML
	private Button editBtn;
	@FXML
	private Label doc_excuselbl11;
	@FXML
	private Label errorLabel1;
	@FXML
	private ComboBox dateMenu;
	@FXML
	private Label excuseLabel;
	@FXML
	private CheckBox checkExcuseBox;
	@FXML
	private Label newDate;
	@FXML
	private ComboBox newDateMenu;
	@FXML
	private Label newResTime;
	@FXML
	private ComboBox newTimesMinue;
	 SystemManager sys = SystemManager.Singleton();
	// Event Listener on ComboBox[#docMenu].onAction
	@FXML
	public void doctorNamesSelect(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on ComboBox[#timesMenu].onAction
	@FXML
	public void timesMenuSelect(ActionEvent event) {
		String doc=docMenu.getSelectionModel().getSelectedItem().toString();
		String date=dateMenu.getSelectionModel().getSelectedItem().toString();
		if(doc!=null &&date!=null) {
			
			timesMenu.setItems( FXCollections.observableArrayList(sys.DisplaySchedule(doc, date)));
			
		}else {
			errorLabel1.setText("please fill doctor and date boxes");
		}
		
	}
	// Event Listener on Button[#editBtn].onAction
	@FXML
	public void editAppointFunc(ActionEvent event) {
		String doc=docMenu.getSelectionModel().getSelectedItem().toString();
		String date=dateMenu.getSelectionModel().getSelectedItem().toString();
		String time=timesMenu.getSelectionModel().getSelectedItem().toString();
		
		if(editBtn.getText().equals("Find")) {
		if(date!=null && time!=null && doc!=null) {
			newResTime.setVisible(true);
			newTimesMinue.setVisible(true);
			excuseLabel.setVisible(true);
			checkExcuseBox.setVisible(true);
			newDate.setVisible(true);
			newDateMenu.setVisible(true);
			editBtn.setText("Edit");
			
		}
		
		else 
			errorLabel1.setText("please fill all boxes");
		}
		else {
			String newDate=newDateMenu.getSelectionModel().getSelectedItem().toString();
			String newTime=newTimesMinue.getSelectionModel().getSelectedItem().toString();
			if(newDate!=null&&newTime!=null)
			sys.secertaryEditApointment(doc,time,date,newDate,newTime,checkExcuseBox.isSelected() );
			else
				errorLabel1.setText("please fill what you want to change");
		}
	}
	// Event Listener on ComboBox[#dateMenu].onAction
	@FXML
	public void dateMenuSelect(ActionEvent event) {
		// TODO Autogenerated
	}
	public void newTimesMenuSelect(ActionEvent event) {
		String doc=docMenu.getSelectionModel().getSelectedItem().toString();
		String date=dateMenu.getSelectionModel().getSelectedItem().toString();
		if(doc!=null &&date!=null) {
			
			timesMenu.setItems( FXCollections.observableArrayList(sys.DisplaySchedule(doc, date)));
			
		}else {
			errorLabel1.setText("please fill doctor and date boxes");
		}
	}
	@Override
public void initialize(URL url,ResourceBundle rb) {
			docMenu.setItems(FXCollections.observableArrayList(sys.docNamesList(sys.getDoctors())));
			dateMenu.setItems(FXCollections.observableArrayList("Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"));
		}
}