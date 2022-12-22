package UIControllers;

import UIFiles.*;
import application.SystemManager;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.ListView;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;

public class displayScheduleController {
	SystemManager sys = SystemManager.Singleton();

	@FXML
	private AnchorPane operationScreenShower;
	@FXML
	private ComboBox docMenuSched;
	@FXML
	private ComboBox daysMenu;
	@FXML
	private Button displaybtn;
	@FXML
	private ListView<String> TimeslotsList;
	@FXML
	private Label displaySuccesslbl;

	// Event Listener on ComboBox[#docMenuSched].onAction
	@FXML
	public void doctorSelectSchedFunc(ActionEvent event) {
		String doc=docMenuSched.getSelectionModel().getSelectedItem().toString();
		if(doc != null)
			displaySuccesslbl.setText("Doctor successfully choosen: "+doc);
		else
			displaySuccesslbl.setText("Doctor is not yet choosen");
	}
	// Event Listener on ComboBox[#daysMenu].onAction
	@FXML
	public void dayScheduleSelectFunc(ActionEvent event) {
		String day=daysMenu.getSelectionModel().getSelectedItem().toString();
		if(day != null)
			displaySuccesslbl.setText("Day successfully choosen: "+day);
		else
			displaySuccesslbl.setText("Day is not yet choosen");
	}
	// Event Listener on Button[#displaybtn].onAction
	@FXML
	public void displayScheduleFunc(ActionEvent event) {
		String doc1 = docMenuSched.getSelectionModel().getSelectedItem().toString();//These are the selected strings but renamed
		String day1 = daysMenu.getSelectionModel().getSelectedItem().toString();	//to avoid any conflict with the above
		if(doc1==null || day1 ==null)
		{
			displaySuccesslbl.setText("Error! There is a missing field");
		}
		else
		{
			displaySuccesslbl.setText("Choice Successfull");

			//ArrayList<String> scheduleCopy = new ArrayList<String>(); //make a new ArrayList to copy the schedule returned
			//Collections.copy(scheduleCopy,sys.DisplaySchedule(doc1,day1)); //copy what is returned from DisplaySchedule to scheduleCopy
			//for(String str : scheduleCopy)
			//{
			//}
			//simpler way down
			TimeslotsList.getItems().addAll(sys.DisplaySchedule(doc1,day1)); //needs to be tested when the required functions are done
																			//it normally takes a collection I dont know what will be the behaviour
																			//when it takes arrayList
		}
	}
}
