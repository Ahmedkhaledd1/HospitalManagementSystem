package UIControllers;

import java.awt.Label;
import java.io.IOException;

import application.Main;
//import UIFiles.*;
import application.SystemManager;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        if(userN==null || pass ==null)
        {
            statusLoginlbl.setText("Error! Unsuccessful login! User Name or Password is missing");
        }
        else
        {
            statusLoginlbl.setText("Login Successfull");
            sys.doctorLogin(userN,pass);
            Main m = new Main();
    		m.changeScene("Doctor.fxml");
        }



    }

    @FXML
    void secretaryLoginFunc(ActionEvent event) throws IOException {

        userN = userNameTxt.getText();
        pass = passwordTxt.getText();
        if(userN==null || pass ==null)
        {
            statusLoginlbl.setText("Error! Unsuccessful login! User Name or Password is missing");
        }
        else
        {
            statusLoginlbl.setText("Login Successfull");
            sys.secretaryLogin(userN,pass);
            
            Main m = new Main();
    		m.changeScene("Secertary.fxml");
        }

    }

}

