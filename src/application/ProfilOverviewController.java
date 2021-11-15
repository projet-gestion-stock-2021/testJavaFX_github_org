package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ProfilOverviewController {

	@FXML
	private Button annulerButton;
	@FXML
	private Label donneeInvalideLabel;
	@FXML
	private TextField identifiantTextField;
	@FXML
	private PasswordField mdpTextField;

	
	
	public void identifiantButtonOnAction (ActionEvent event) {
		
		
		if(identifiantTextField.getText().isBlank() == false && mdpTextField.getText().isBlank() == false)  {
			validationIdent();
		} else {
			donneeInvalideLabel.setText("Entrez votre MDP et identifiant");
		}
		
	}
	
	public void cancelButtonOnAction(ActionEvent event) {
		Stage stage = (Stage) annulerButton.getScene().getWindow();
		stage.close(); 
	}
	public void validationIdent() {
		Database connectNow = new Database();
		Connection connectDb = connectNow.getConnection();
		
		String verifId= "select count(1) from client where nomClient = '" + mdpTextField.getText() + "' and prenom = '" + identifiantTextField.getText() + "' ";
		
		
		try {
			
			Statement statement = connectDb.createStatement();
			ResultSet queryResult = statement.executeQuery(verifId);
					
		} catch(Exception e){
			e.printStackTrace();
			e.getCause(); 
		}
	}
}
