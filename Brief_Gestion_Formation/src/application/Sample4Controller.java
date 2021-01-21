package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Sample4Controller implements  Initializable{
	
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
	private ImageView brandingImageView;
	
	@FXML
	private Label loginMessageLabel;
    
    
    
    @Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		File brandingFile = new File("Images/image.png");
		Image brandingImage = new Image(brandingFile.toURI().toString());
		brandingImageView.setImage(brandingImage);
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
    		
    		JOptionPane.showMessageDialog(null, "Users Add succes");
    		
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
    
    
    @FXML
    void sendToSene2Ation(ActionEvent event) {
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
}
