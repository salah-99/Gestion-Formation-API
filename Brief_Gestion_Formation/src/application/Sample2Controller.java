package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Sample2Controller{
	 @FXML
	    private TableView<session> table_session;

	    @FXML
	    private TableColumn<session, Integer> col_id_s;

	    @FXML
	    private TableColumn<session, String> col_code;

	    @FXML
	    private TableColumn<session, String> col_libellé;

	
	    
	    @FXML
	    private TextField txt_code;

	    @FXML
	    private TextField txt_libellé;

	    @FXML
	    private TextField txt_id_s;

	 
	    
	    
	    ObservableList<session> Listt;
	    
	    
	    int index =-1;
	    
	    Connection conn =null;
	    ResultSet rs =null;
	    PreparedStatement pst = null;
	    
	    
	    public void Add_session() {
	    	conn = mysqlconnect.ConnectDB();
	    	String sql = "INSERT INTO session where formation = id_f   (code,libellé)VALUES(?,?)";
	    	
	    	try {
	    		pst = conn.prepareStatement(sql);
	    		
	    		pst.setString(1 ,txt_code.getText());
	    		pst.setString(2, txt_libellé.getText());
	    	
	    		pst.execute();
	    		
	    		JOptionPane.showMessageDialog(null, "Session Add succes");
	    		UpdateTable_session(); 
	    	}
	    	catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, e);
	    	}
	    }
	    
	    
	    ////method selecct user///
	    @FXML
	    void getSelected (MouseEvent event) {
	    	index = table_session.getSelectionModel().getSelectedIndex();
	    	if(index <= -1) {
	    		
	    		
	    		return;
	    	}
	    	txt_id_s.setText(col_id_s.getCellData(index).toString());
	    	txt_code.setText(col_code.getCellData(index).toString());
	    	txt_libellé.setText(col_libellé.getCellData(index).toString());
	    	
	    }
	    
	    
	    public void Edit_session() {
	    	try {
	    		conn = mysqlconnect.ConnectDB();
	    		String value1 = txt_id_s.getText();
	    		String value2 = txt_code.getText();
	    		String value3 = txt_libellé.getText();
	 
	    		
	    		String sql = "update session set id_s='"+value1+"',code= '"+value2+"' , libellé= '"+value3+"' where id_s= '"+value1+"' ";
	    		 
	    		pst=conn.prepareStatement(sql);
	    		pst.execute();
	    		JOptionPane.showMessageDialog(null, "Update");
	    		UpdateTable_session();
	    		
	    	}
	    	catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, e);
	    	}
	    }
	    
	    
	    public void Delete_session() {
	    	conn= mysqlconnect.ConnectDB();
	    	String sql = "delete from session where id_s= ?";
	    	
	    	try {
	    		pst = conn.prepareStatement(sql);
	    		pst.setString(1, txt_id_s.getText());
	    		pst.execute();
	    		JOptionPane.showMessageDialog(null, "Delete_session");
	    		UpdateTable_session();
	    		
	    	}
	    	catch(Exception e) {
	    		JOptionPane.showMessageDialog(null, e);
	    	}
	    }
	    
	    
	    
	    
	    public void UpdateTable_session() {
	    	
	    	col_id_s.setCellValueFactory(new PropertyValueFactory<session,Integer>("id_s"));
			col_code.setCellValueFactory(new PropertyValueFactory<session,String>("code"));
			col_libellé.setCellValueFactory(new PropertyValueFactory<session,String>("libellé"));
	
		
			Listt = mysqlconnect.getDatasession();
			table_session.setItems(Listt); 
	    }
	     

}
