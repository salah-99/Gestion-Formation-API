package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mysqlconnect {
 
	Connection conn=null;
	
	public static Connection ConnectDB() {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations_1", "root", "");
		    return conn;
		}
			
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	
	
	public static ObservableList<users> getDatausers(){
		Connection conn =ConnectDB();
		ObservableList<users> List = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `formation`");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				List.add(new users(rs.getInt("id_f"), rs.getString("code"), rs.getString("libellé"), rs.getString("description")));
			}
		}
		catch(Exception e) {
			
		}
		
		
		
	    return List;    
	}


	public static ObservableList<session> getDatasession() {
		// TODO Auto-generated method stub
		
		Connection conn =ConnectDB();
		ObservableList<session> Listt = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `session`");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Listt.add(new session(rs.getInt("id_s"), rs.getString("code"), rs.getString("libellé")));
			}
		}
		catch(Exception e) {
			
		}
		
		
		
	    return Listt; 
	    
	}
	
	public static ObservableList<employe> getDataemploye(){
		Connection conn =ConnectDB();
		ObservableList<employe> Listtt = FXCollections.observableArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `employe`");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Listtt.add(new employe(rs.getInt("id_e"), rs.getString("matricule"), rs.getString("flname"), rs.getString("username"), rs.getString("ville"), rs.getString("pass")));
			}
		}
		catch(Exception e) {
			
		}
		
		
		
	    return Listtt; 
	    
	}

	
}
