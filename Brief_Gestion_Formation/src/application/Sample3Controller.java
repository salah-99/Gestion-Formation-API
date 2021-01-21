package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Sample3Controller implements Initializable{
	
	ObservableList<String> ChoiceBoxList = FXCollections.observableArrayList("safi", "agadir", "tanger", "casablanca");
	
	@FXML
    private TextField matriculleTextField;

    @FXML
    private TextField villeTextField;

    @FXML
    private TextField flnameTextField;

    @FXML
    private TextField usernameTextField;
    
    @FXML
    private PasswordField enterPasswordField;
    
    @FXML
    private Button cancelButton;
    
    @FXML
    private Button signupButton;
    
	
	@FXML
	private Label loginMessageLabel;
	
	@FXML
	private ChoiceBox<String> villeChoiceBox;
	
	@FXML
	private WebView maps;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//villeChoiceBox.setItems(ChoiceBoxList);
	}
    
    public void cancelButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) cancelButton.getScene().getWindow();
		stage.close();
	}
    
ObservableList<employe> Listtt;
    
    
    int index =-1;
    
    Connection conn =null;
    ResultSet rs =null;
    PreparedStatement pst = null;
    
    public void signupButtonOnAction(ActionEvent event) {
		if(matriculleTextField.getText().isEmpty() == false && villeTextField.getText().isEmpty() == false && flnameTextField.getText().isEmpty() == false && usernameTextField.getText().isEmpty() == false && enterPasswordField.getText().isEmpty() == false) {
			Add_admin();
			//test();
			
		}else {
			loginMessageLabel.setText("Please enter info");
		}
	}
    
    public void Add_admin() {
    	conn = mysqlconnect.ConnectDB();
    	String sql = "INSERT INTO employe (matricule,ville,flname,username,pass)VALUES(?,?,?,?,?)";
    	
    	try {
    		pst = conn.prepareStatement(sql);
    		pst.setString(1 , matriculleTextField.getText());
    		pst.setString(2, villeTextField.getText());
    		pst.setString(3, flnameTextField.getText());
    		pst.setString(4, usernameTextField.getText());
    		pst.setString(5, enterPasswordField.getText());
    		pst.execute();
    		
    	     FXMLLoader loader= new FXMLLoader(getClass().getResource("Sample.fxml"));
    	     Parent root = (Parent) loader.load();
    	     
    	     Stage stage =new Stage();
    	     
    	     stage.setScene(new Scene(root));
    	     stage.setTitle("Apliation Gestion des formations 'Formation' ");
    	     stage.show();
    	     
    	    stage = (Stage) signupButton.getScene().getWindow();
    		stage.close();
    		
    		JOptionPane.showMessageDialog(null, "Bsa7tak");
    		
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
    
    public void test() {
    	System.out.println("the value is :" + villeChoiceBox.getValue());
    }
    /*
    @FXML
    void sendToSene3Ation(ActionEvent event) {
     try {	
     FXMLLoader loader= new FXMLLoader(getClass().getResource("Sample.fxml"));
     Parent root = (Parent) loader.load();
     
     Stage stage =new Stage();
     
     stage.setScene(new Scene(root));
     stage.setTitle("Apliation Gestion des formations 'Formation' ");
     stage.show();
     }
     catch(Exception e) {
     	System.out.println("Can load new session");
     }
     
     
    
     }
     */
}
