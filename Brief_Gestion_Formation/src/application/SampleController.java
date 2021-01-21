package application;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SampleController {
	
    @FXML
    private TableView<users> table_users;

    @FXML
    private TableColumn<users, Integer> col_id_f;

    @FXML
    private TableColumn<users, String> col_code;

    @FXML
    private TableColumn<users, String> col_libelle;

    @FXML
    private TableColumn<users, String> col_description;
    
    @FXML
    private TextField txt_code;

    @FXML
    private TextField txt_libelle;

    @FXML
    private TextField txt_description;

    @FXML
    private TextField txt_id_f;
    
    
    
    
    
    
    
  ObservableList<users> List;
    
    
    int index =-1;
    
    Connection conn =null;
    ResultSet rs =null;
    PreparedStatement pst = null;
    
    
    public void Add_users() {
    	conn = mysqlconnect.ConnectDB();
    	String sql = "INSERT INTO formation (code,libell�,description)VALUES(?,?,?)";
    	
    	try {
    		pst = conn.prepareStatement(sql);
    		
    		pst.setString(1 ,txt_code.getText());
    		pst.setString(2, txt_libelle.getText());
    		pst.setString(3, txt_description.getText());
    		pst.execute();
    		
    		JOptionPane.showMessageDialog(null, "Users Add succes");
    		UpdateTable(); 
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
    
    
    ////method selecct user///
    @FXML
    void getSelected (MouseEvent event) {
    	index = table_users.getSelectionModel().getSelectedIndex();
    	if(index <= -1) {
    		
    		
    		return;
    	}
    	txt_id_f.setText(col_id_f.getCellData(index).toString());
    	txt_code.setText(col_code.getCellData(index).toString());
    	txt_libelle.setText(col_libelle.getCellData(index).toString());
    	txt_description.setText(col_description.getCellData(index).toString());
    }
    
    
    public void Edit() {
    	try {
    		conn = mysqlconnect.ConnectDB();
    		String value1 = txt_id_f.getText();
    		String value2 = txt_code.getText();
    		String value3 = txt_libelle.getText();
    		String value4 = txt_description.getText();
    		
    		String sql = "update formation set id_f='"+value1+"',code= '"+value2+"' , libelle= '"+value3+"', description= '"+value4+"' where id_f= '"+value1+"' ";
    		 
    		pst=conn.prepareStatement(sql);
    		pst.execute();
    		JOptionPane.showMessageDialog(null, "Update");
    		UpdateTable();
    		
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
    
  
    
    public void Delete() {
    	conn= mysqlconnect.ConnectDB();
    	String sql = "delete from formation where id_f= ?";
    	
    	try {
    		pst = conn.prepareStatement(sql);
    		pst.setString(1, txt_id_f.getText());
    		pst.execute();
    		JOptionPane.showMessageDialog(null, "Delete");
    		UpdateTable();
    		
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, e);
    	}
    }
    
    
    @FXML
   public void sendToSene3Ation(ActionEvent event) {
    try {	
    	conn = mysqlconnect.ConnectDB();
    	
    	String url="http://localhost:3000/";
    	java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    	JOptionPane.showMessageDialog(null, "nadi");
		UpdateTable();
    }
    catch(Exception e) {
    	
    	JOptionPane.showMessageDialog(null, e);
   
    }
    }

    
    @FXML
    void sendToSene2Ation(ActionEvent event) {
     try {	
     FXMLLoader loader= new FXMLLoader(getClass().getResource("Sample2.fxml"));
     Parent root = (Parent) loader.load();
     
     Stage stage =new Stage();
     
     stage.setScene(new Scene(root));
     stage.setTitle("Apliation Gestion des formations 'Session' ");
     stage.show();
     }
     catch(Exception e) {
     	System.out.println("Can load new session");
     }
     
    
     }	
    
    
    @FXML
    void sendToSene4Ation(ActionEvent event) {
     try {	
     FXMLLoader loader= new FXMLLoader(getClass().getResource("Employe.fxml"));
     Parent root = (Parent) loader.load();
     
     Stage stage =new Stage();
     
     stage.setScene(new Scene(root));
     stage.setTitle("Apliation Gestion des formations 'Session' ");
     stage.show();
     }
     catch(Exception e) {
     	System.out.println("Can load new session");
     }
     
    
     }

    
    
    public void UpdateTable() {
    	col_id_f.setCellValueFactory(new PropertyValueFactory<users,Integer>("id_f"));
		col_code.setCellValueFactory(new PropertyValueFactory<users,String>("code"));
		col_libelle.setCellValueFactory(new PropertyValueFactory<users,String>("libelle"));
		col_description.setCellValueFactory(new PropertyValueFactory<users,String>("description"));
	
		List = mysqlconnect.getDatausers();
		table_users.setItems(List); 
    }
     


}

