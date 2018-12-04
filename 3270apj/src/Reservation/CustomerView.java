package Reservation;

import Application.Customer;
import Data.CustomerData;
import Data.FlightData;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class CustomerView extends Application{
	public static TableColumn idCustomerC;
	public static TableColumn firstNameC;
	public static TableColumn lastNameC;
	public static TableColumn streetC;
	public static TableColumn cityC;
	public static TableColumn stateC;
	public static TableColumn zipCodeC;
	public static TableColumn emailC;
	public static TableColumn ssnC;
	public static TableColumn userNameC;
	public static TableColumn passwordC;
	public static TableColumn securityQuestionC;
	public static TableColumn securityAnswerC;
		
	public static TextField firstNameA;
	public static TextField lastNameA;
	public static TextField streetA;
	public static TextField cityA;
	public static TextField stateA;
	public static TextField zipCodeA;
	public static TextField emailA;
	public static TextField ssnA;
	public static TextField userNameA;
	public static TextField passwordA;
	public static TextField securityQuestionA;
	public static TextField securityAnswerA;
	
	public static TextField idCustomerU;
	public static TextField firstNameU;
	public static TextField lastNameU;
	public static TextField streetU;
	public static TextField cityU;
	public static TextField stateU;
	public static TextField zipCodeU;
	public static TextField emailU;
	public static TextField ssnU;
	public static TextField userNameU;
	public static TextField passwordU;
	public static TextField securityQuestionU;
	public static TextField securityAnswerU;
	
	public static TextField idCustomerD;
	public static TextField ssnD;
	
	SignUpForm signUp;
	
	public static TableView<Customer> table = new TableView<Customer>();
	
	Stage customerViewStage;
	
	public static void main(String[] args) {
        launch(args);
    }
	
	//Table UI
	public void start(Stage stage) {
		customerViewStage = stage;
		signUp = new SignUpForm();
		Scene scene = new Scene(new Group());
		stage.setTitle("Customer Information");
		stage.setFullScreen(true);
		
		//Name of the table
		Label label = new Label("APJ - Customer Information");
		label.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		
		//Create column
		idCustomerC = new TableColumn("Customer ID");
		idCustomerC.setMinWidth(50);
		idCustomerC.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("idCustomer"));
		
		firstNameC = new TableColumn("First Name");
		firstNameC.setMinWidth(100);
		firstNameC.setCellValueFactory(new PropertyValueFactory<Customer, String>("firstName"));
		
		lastNameC = new TableColumn("Last Name");
		lastNameC.setMinWidth(100);
		lastNameC.setCellValueFactory(new PropertyValueFactory<Customer, String>("lastName"));
		
		streetC = new TableColumn("Street");
		streetC.setMinWidth(100);
		streetC.setCellValueFactory(new PropertyValueFactory<Customer, String>("street"));
		
		cityC = new TableColumn("City");
		cityC.setMinWidth(100);
		cityC.setCellValueFactory(new PropertyValueFactory<Customer, String>("city"));
		
		stateC = new TableColumn("State");
		stateC.setMinWidth(100);
		stateC.setCellValueFactory(new PropertyValueFactory<Customer, String>("state"));
		
		zipCodeC = new TableColumn("Zip Code");
		zipCodeC.setMinWidth(100);
		zipCodeC.setCellValueFactory(new PropertyValueFactory<Customer, String>("zipCode"));
		
		emailC = new TableColumn("Email");
		emailC.setMinWidth(100);
		emailC.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
				
		ssnC = new TableColumn("SSN");
		ssnC.setMinWidth(100);
		ssnC.setCellValueFactory(new PropertyValueFactory<Customer, String>("ssn"));
		
		userNameC = new TableColumn("Username");
		userNameC.setMinWidth(100);
		userNameC.setCellValueFactory(new PropertyValueFactory<Customer, String>("userName"));
		
		passwordC = new TableColumn("Password");
		passwordC.setMinWidth(100);
		passwordC.setCellValueFactory(new PropertyValueFactory<Customer, String>("password"));
		
		securityQuestionC = new TableColumn("Security Question");
		securityQuestionC.setMinWidth(100);
		securityQuestionC.setCellValueFactory(new PropertyValueFactory<Customer, String>("securityQuestion"));
		
		securityAnswerC = new TableColumn("Security Answer");
		securityAnswerC.setMinWidth(100);
		securityAnswerC.setCellValueFactory(new PropertyValueFactory<Customer, String>("securityAnswer"));
		
		
		loadTable();
		
			
		//field for add box
		firstNameA = new TextField();
		firstNameA.setPromptText("First Name");
		firstNameA.setMaxWidth(firstNameC.getPrefWidth());
		
		lastNameA = new TextField();
		lastNameA.setPromptText("Last Name");
		lastNameA.setMaxWidth(lastNameC.getPrefWidth());
		
		streetA = new TextField();
		streetA.setPromptText("Street");
		streetA.setMaxWidth(streetC.getPrefWidth());
		
		cityA = new TextField();
		cityA.setPromptText("City");
		cityA.setMaxWidth(cityC.getPrefWidth());
		
		stateA = new TextField();
		stateA.setPromptText("State");
		stateA.setMaxWidth(stateC.getPrefWidth());
		
		zipCodeA = new TextField();
		zipCodeA.setPromptText("Zip Code");
		zipCodeA.setMaxWidth(zipCodeC.getPrefWidth());
		
		emailA = new TextField();
		emailA.setPromptText("Email");
		emailA.setMaxWidth(emailC.getPrefWidth());
		
		ssnA = new TextField();
		ssnA.setPromptText("SSN");
		ssnA.setMaxWidth(ssnC.getPrefWidth());
		
		userNameA = new TextField();
		userNameA.setPromptText("Username");
		userNameA.setMaxWidth(userNameC.getPrefWidth());
		
		passwordA = new TextField();
		passwordA.setPromptText("Password");
		passwordA.setMaxWidth(passwordC.getPrefWidth());
		
		securityQuestionA = new TextField();
		securityQuestionA.setPromptText("Question");
		securityQuestionA.setMaxWidth(securityQuestionC.getPrefWidth());
		
		securityAnswerA = new TextField();
		securityAnswerA.setPromptText("Answer");
		securityAnswerA.setMaxWidth(securityAnswerC.getPrefWidth());
		
		//create field for update box
		idCustomerU = new TextField();
		idCustomerU.setPromptText("ID");
		idCustomerU.setMaxWidth(idCustomerC.getPrefWidth());
		
		firstNameU = new TextField();
		firstNameU.setPromptText("First Name");
		firstNameU.setMaxWidth(firstNameC.getPrefWidth());
		
		lastNameU = new TextField();
		lastNameU.setPromptText("Last Name");
		lastNameU.setMaxWidth(lastNameC.getPrefWidth());
		
		streetU = new TextField();
		streetU.setPromptText("Street");
		streetU.setMaxWidth(streetC.getPrefWidth());
		
		cityU = new TextField();
		cityU.setPromptText("City");
		cityU.setMaxWidth(cityC.getPrefWidth());
		
		stateU = new TextField();
		stateU.setPromptText("State");
		stateU.setMaxWidth(stateC.getPrefWidth());
		
		zipCodeU = new TextField();
		zipCodeU.setPromptText("Zip Code");
		zipCodeU.setMaxWidth(zipCodeC.getPrefWidth());
		
		emailU = new TextField();
		emailU.setPromptText("Email");
		emailU.setMaxWidth(emailC.getPrefWidth());
		
		ssnU = new TextField();
		ssnU.setPromptText("SSN");
		ssnU.setMaxWidth(ssnC.getPrefWidth());
		
		userNameU = new TextField();
		userNameU.setPromptText("Username");
		userNameU.setMaxWidth(userNameC.getPrefWidth());
		
		passwordU = new TextField();
		passwordU.setPromptText("Password");
		passwordU.setMaxWidth(passwordC.getPrefWidth());
		
		securityQuestionU = new TextField();
		securityQuestionU.setPromptText("Question");
		securityQuestionU.setMaxWidth(securityQuestionC.getPrefWidth());
		
		securityAnswerU = new TextField();
		securityAnswerU.setPromptText("Answer");
		securityAnswerU.setMaxWidth(securityAnswerC.getPrefWidth());
		
		//create field for delete box
		idCustomerD = new TextField();
		idCustomerD.setPromptText("ID");
		idCustomerD.setMaxWidth(idCustomerC.getPrefWidth());
				
		ssnD = new TextField();
		ssnD.setPromptText("SSN");
		ssnD.setMaxWidth(ssnC.getPrefWidth());
		
		
		//Create add button
		Button addButton = new Button("Add");
		addButton.setOnAction((event) -> {
			if(!signUp.isValidEmail(emailA.getText()) || 
					!signUp.checkIfExist(userNameA.getText(), ssnA.getText()) || 
					!signUp.isValidSsn(ssnA.getText())) {
				GridPane alert = new GridPane();
				Scene sc = new Scene(alert, 200, 200);
				showAlert(Alert.AlertType.ERROR, alert.getScene().getWindow(), "Error!",
						"Fields are not valid");
			} else {
				CustomerData.insertCustomer();
			}
		});
		//create update button
		Button updateButton = new Button("Update");
		updateButton.setOnAction((event) -> { CustomerData.updateCustomer();});
		
		//create delete button
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction((event) -> { CustomerData.deleteCustomer();});
		
		//create back button
		Button backButton = new Button("Back");
		backButton.setOnAction(e -> {
			try {
				Stage adminStage = new Stage();
				AdminStage booking = new AdminStage();
				booking.start(adminStage);
				adminStage.show();
				customerViewStage.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		
		//create box to add text
		HBox addBox = new HBox();
		addBox.getChildren().addAll(firstNameA, lastNameA, streetA, cityA, stateA, zipCodeA, emailA, ssnA, userNameA, passwordA, securityQuestionA, securityAnswerA, addButton);
		addBox.setSpacing(10);
		
		//create box to update text
		HBox updateBox = new HBox();
		updateBox.getChildren().addAll(idCustomerU, firstNameU, lastNameU, streetU, cityU, stateU, zipCodeU, emailU, ssnU, userNameU, passwordU, securityQuestionU, securityAnswerU, updateButton);
		addBox.setSpacing(10);
		
		//create delete box
		HBox deleteBox = new HBox();
		deleteBox.setSpacing(10);
		deleteBox.getChildren().addAll(idCustomerD, ssnD, deleteButton);

		//create back box
		HBox backBox = new HBox();
		backBox.getChildren().addAll(backButton);
		backBox.setAlignment(Pos.BOTTOM_LEFT);
		
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table, addBox, updateBox, deleteBox, backBox);
		
		((Group) scene.getRoot()).getChildren().addAll(vbox);
		
		stage.setScene(scene);
		stage.show();
	}
	
	//Load the table
	public static void loadTable() {
		ObservableList<Customer> data = CustomerData.getCustomer();
		table.getColumns().addAll(idCustomerC, firstNameC, lastNameC, streetC, cityC, stateC, zipCodeC, emailC, ssnC, userNameC, passwordC, securityQuestionC, securityAnswerC);
		table.getItems().addAll(data);
	}	
	
	// Layout for alerts 
		public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
			Alert alert = new Alert(alertType);
			alert.setTitle(title);
			alert.setHeaderText(null);
			alert.setContentText(message);
			alert.initOwner(owner);
			alert.show();
		}
}
