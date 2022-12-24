package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.ListView;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;

public class displayScheduleController implements Initializable {
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
		String doc1=null;
		String day1=null;
		if(docMenuSched.getSelectionModel().getSelectedItem()!=null&&daysMenu.getSelectionModel().getSelectedItem()!=null) {
			 doc1 = docMenuSched.getSelectionModel().getSelectedItem().toString();//These are the selected strings but renamed
			 day1 = daysMenu.getSelectionModel().getSelectedItem().toString();	//to avoid any conflict with the above
		}
		if(doc1==null || day1 ==null)
		{
			displaySuccesslbl.setText("Error! There is a missing field");
		}
		else
		{
			displaySuccesslbl.setText("Choice Successfull");

			if(sys.DisplaySchedule(doc1,day1)!=null) {
			TimeslotsList.getItems().addAll( sys.DisplaySchedule(doc1,day1)); 
			
			//TimeslotsList.getItems().addAll(FXCollections.observableArrayList(sys.DisplaySchedule(doc1,day1))) ;
			displaySuccesslbl.setText("ifffffffff");
			//System.out.println("i displayed null");
			}else {
				TimeslotsList.getItems().addAll(" "); 
				//TimeslotsList.getItems().addAll( (String[]) (sys.DisplaySchedule(doc1,day1).toArray())); 
				
				displaySuccesslbl.setText("elseeeeeeeee");
				
			}
		}
	}
	
public void initialize(URL url,ResourceBundle rb) {
		
		//	ObservableList<String>list=FXCollections.observableArrayList(sys.docNamesList(sys.getDoctors()));
			
			docMenuSched.setItems(FXCollections.observableArrayList(sys.docNamesList(sys.getDoctors())));
			daysMenu.setItems(FXCollections.observableArrayList("Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"));
			
			
			
		}
}
