package UIControllers;

import java.net.URL;
import java.util.ResourceBundle;

//import UIFiles.*;
import application.SystemManager;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;

public class initiateExcuseController implements Initializable {
	SystemManager sys = SystemManager.Singleton();

	@FXML
	private AnchorPane operationScreenShower;
	@FXML
	private ComboBox docExcuseMenu;
	@FXML
	private Label doc_excuselbl;
	@FXML
	private Label day_excuselbl;
	@FXML
	private ComboBox daysMenu;
	@FXML
	private Button excuse_confirmbtn;
	@FXML
	private Label errorLabel;

	// Event Listener on ComboBox[#docExcuseMenu].onAction
	@FXML
	public void doctorExcuseSelect(ActionEvent event) {
		String doc=docExcuseMenu.getSelectionModel().getSelectedItem().toString();
		if(doc != null)
			errorLabel.setText("Doctor successfully choosen: "+doc);
		else
			errorLabel.setText("Doctor is not yet choosen");
	}
	// Event Listener on ComboBox[#daysMenu].onAction
	@FXML
	public void dayExcuseSelect(ActionEvent event) {
		String day=daysMenu.getSelectionModel().getSelectedItem().toString();
		if(day != null)
			errorLabel.setText("Day successfully choosen: "+day);
		else
			errorLabel.setText("Day is not yet choosen");
	}
	// Event Listener on Button[#excuse_confirmbtn].onAction
	@FXML
	public void excuseConfirmFunc(ActionEvent event) {
		String doc1 = docExcuseMenu.getSelectionModel().getSelectedItem().toString();//These are the selected strings but renamed
		String day1 = daysMenu.getSelectionModel().getSelectedItem().toString();	//to avoid any conflict with the above
		if(doc1==null || day1 ==null)
		{
			errorLabel.setText("Error! There is a missing field");
		}
		else
		{
			errorLabel.setText("Choice Successfull");
			sys.secertaryIntiateExcuse(doc1,day1);
		}
	}
	
public void initialize(URL url,ResourceBundle rb) {
			
			docExcuseMenu.setItems(FXCollections.observableArrayList(sys.docNamesList(sys.getDoctors())));
			daysMenu.setItems(FXCollections.observableArrayList("Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"));
			
			
			
		}
	
}
