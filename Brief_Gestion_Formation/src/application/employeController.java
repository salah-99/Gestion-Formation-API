package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class employeController implements Initializable {
	
	
	@FXML
	private TableView<employe> tvBox;
	
	@FXML
	private TableColumn<employe, String> matriculeTableColumn;
	
	@FXML
	private TableColumn<employe, String> flnameTableColumn;
	
	@FXML
	private TableColumn<employe, String> usernameTableColumn;
	
	@FXML
	private TableColumn<employe, String> villeTableColumn;
	
	@FXML
	private WebView imageWebView;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		showFormation();
		
		WebEngine web = imageWebView.getEngine();
		web.load("https://salah-99.github.io/map-fx/index.html?X=33.68444801721177&Y=-7.381857266161996");
	}
	
	
	public Connection getConnection() {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionformations_1", "root", "");
			return conn;
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}
	
		public ObservableList<employe> getDataemploye() {
			ObservableList<employe> formationList = FXCollections.observableArrayList();
			Connection conn = getConnection();
			String query = "SELECT * FROM  employe";
			Statement st;
			ResultSet rs;
			
			try {
				st = conn.createStatement();
				rs = st.executeQuery(query);
				
				employe employe;
				while(rs.next()) {
					employe = new employe(rs.getString("matricule"), rs.getString("ville"), rs.getString("username"), rs.getString("flname"));
					formationList.add(employe);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return formationList;
		}

		public void showFormation() {
			
			try {
				ObservableList<employe> list = getDataemploye();
				
				matriculeTableColumn.setCellValueFactory(new PropertyValueFactory<employe, String>("matricule"));
				usernameTableColumn.setCellValueFactory(new PropertyValueFactory<employe, String>("username"));
				flnameTableColumn.setCellValueFactory(new PropertyValueFactory<employe, String>("flname"));
				villeTableColumn.setCellValueFactory(new PropertyValueFactory<employe, String>("ville"));

				tvBox.setItems(list);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
/*
		private void executeQuery(String query) {
			// TODO Auto-generated method stub
			Connection conn = getConnection();
			Statement st;
			try {
				st = conn.createStatement();
				st.executeUpdate(query);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
*/
		@FXML
		private void handeleMousseAction(MouseEvent event) {
			employe employe = tvBox.getSelectionModel().getSelectedItem();
			//System.out.println("id: " + employee.getId());
			//System.out.println("salary: " + employee.getSalary());
			
			if(employe.getVille().equals("safi")) {
				WebEngine web = imageWebView.getEngine();
				web.load("https://salah-99.github.io/map-fx/index.html?X=32.29740462539648&Y=-9.233969451787024");
			}
			else if(employe.getVille().equals("Nadour")) {
				WebEngine web = imageWebView.getEngine();
				web.load("https://salah-99.github.io/map-fx/index.html?X=35.16962256919354&Y=-2.9285847956978817");
			}
			else if(employe.getVille().equals("Mohamadia")) {
				WebEngine web = imageWebView.getEngine();
				web.load("https://salah-99.github.io/map-fx/index.html?X=33.68444801721177&Y=-7.381857266161996");
			}
			
			System.out.println("OK");
			//WebEngine web = maps.getEngine();
			//web.load("https://yassinaibi.github.io/gestion-de-formation-map/index.html?X=33.29740462539648&Y=-10.233969451787024");
			//colVille.setText(fomation.getVille());
		}
}
