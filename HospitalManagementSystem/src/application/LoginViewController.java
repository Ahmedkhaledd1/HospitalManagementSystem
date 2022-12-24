package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginViewController {
    SystemManager sys = SystemManager.Singleton();
    @FXML
    private Label statusLoginlbl;
    @FXML
    private TextField userNameTxt;
    @FXML
    private TextField passwordTxt;

    String userN;
    String pass;

    @FXML
    void doctorLoginFunc(ActionEvent event) throws IOException {
    	

        userN = userNameTxt.getText();
        pass = passwordTxt.getText();
        if(userN.isEmpty() || pass.isEmpty())
        {
            statusLoginlbl.setText("Error! Unsuccessful login! User Name or Password is missing");
        }
        else
        {
            
            sys.doctorLogin(userN,pass);
            if(sys.getLoginFlag()) {
            	 Main m = new Main();
         		m.changeScene("Doctor.fxml");
         	   
            }else {
         	   statusLoginlbl.setText("Wrong UseName or Password");
         	 
         	   
            }
           ;
        }



    }

    @FXML
    void secretaryLoginFunc(ActionEvent event) throws IOException {

        userN = userNameTxt.getText();
        pass = passwordTxt.getText();
        if(userN.isEmpty() || pass.isEmpty())
        {
            statusLoginlbl.setText("Error! Unsuccessful login! User Name or Password is missing");
        }
        else
        {
           
        
            sys.secretaryLogin(userN,pass);
            
           if(sys.getLoginFlag()) {
        	   Main m = new Main();
       		m.changeScene("Secertary.fxml");
        	   
           }else {
        	   statusLoginlbl.setText("Wrong UseName or Password");
        	   
           }
          
    	
        }
       

    }

}

