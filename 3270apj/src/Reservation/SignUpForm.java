package Reservation;

import Data.CustomerData;
import Data.Database;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import Application.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SignUpForm extends Application {

	static Connection con;
	static ResultSet rs;
	static Statement statement;
	static PreparedStatement ps;

	Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		GridPane gridPane = createLogInFormPane();
		addUIControls(gridPane);
		Scene scene = new Scene(gridPane, 600, 800);
		stage.setScene(scene);
		stage.setTitle("Registration");
		stage.show();
	}

	public GridPane createLogInFormPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(15);
		gridPane.setVgap(15);
		gridPane.setPadding(new Insets(25, 25, 25, 25));

		return gridPane;
	}

	public void addUIControls(GridPane gridPane) {
		// Header
		Label headerLabel = new Label("Registration Form");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		// Create label and textfield
		Label firstNameL = new Label("First Name:");
		gridPane.add(firstNameL, 0, 1);
		TextField firstNameF = new TextField();
		gridPane.add(firstNameF, 1, 1);

		Label lastNameL = new Label("Last Name:");
		gridPane.add(lastNameL, 0, 2);
		TextField lastNameF = new TextField();
		gridPane.add(lastNameF, 1, 2);

		Label streetL = new Label("Street:");
		gridPane.add(streetL, 0, 3);
		TextField streetF = new TextField();
		gridPane.add(streetF, 1, 3);

		Label cityL = new Label("City:");
		gridPane.add(cityL, 0, 4);
		TextField cityF = new TextField();
		gridPane.add(cityF, 1, 4);

		Label stateL = new Label("State:");
		gridPane.add(stateL, 0, 5);
		TextField stateF = new TextField();
		gridPane.add(stateF, 1, 5);

		Label zipCodeL = new Label("Zipcode:");
		gridPane.add(zipCodeL, 0, 6);
		TextField zipCodeF = new TextField();
		gridPane.add(zipCodeF, 1, 6);

		Label emailL = new Label("Email:");
		gridPane.add(emailL, 0, 7);
		TextField emailF = new TextField();
		gridPane.add(emailF, 1, 7);

		Label ssnL = new Label("SSN:");
		gridPane.add(ssnL, 0, 8);
		TextField ssnF = new TextField();
		gridPane.add(ssnF, 1, 8);

		Label userNameL = new Label("Username:");
		gridPane.add(userNameL, 0, 9);
		TextField userNameF = new TextField();
		gridPane.add(userNameF, 1, 9);

		Label passwordL = new Label("Password:");
		gridPane.add(passwordL, 0, 10);
		PasswordField passwordF = new PasswordField();
		gridPane.add(passwordF, 1, 10);

		Label securityQuestionL = new Label("Security Question:");
		gridPane.add(securityQuestionL, 0, 11);
		TextField securityQuestionF = new TextField();
		gridPane.add(securityQuestionF, 1, 11);

		Label securityAnswerL = new Label("Security Answer:");
		gridPane.add(securityAnswerL, 0, 12);
		TextField securityAnswerF = new TextField();
		gridPane.add(securityAnswerF, 1, 12);

		// create back button
		Button backButton = new Button("Back");
		HBox h1 = new HBox();
		h1.setAlignment(Pos.BOTTOM_LEFT);
		h1.getChildren().add(backButton);
		gridPane.add(h1, 0, 14);

		// create signup button
		Button signUpButton = new Button("Sign Up");
		HBox h2 = new HBox();
		h2.setAlignment(Pos.BOTTOM_RIGHT);
		h2.getChildren().add(signUpButton);
		gridPane.add(h2, 1, 14);

		final Text actiontarget = new Text();
		gridPane.add(actiontarget, 1, 15);

		EventHandler<MouseEvent> signupEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (e.getButton() == MouseButton.PRIMARY) {
					try {

						if (firstNameF.getText().isEmpty() || lastNameF.getText().isEmpty()
								|| streetF.getText().isEmpty() || cityF.getText().isEmpty()
								|| stateF.getText().isEmpty() || zipCodeF.getText().isEmpty()
								|| emailF.getText().isEmpty() || ssnF.getText().isEmpty()
								|| userNameF.getText().isEmpty() || passwordF.getText().isEmpty()
								|| securityQuestionF.getText().isEmpty() || securityAnswerF.getText().isEmpty()) {

							showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!",
									"Please fill in blank!");

						} else {
							if (checkUsernameExist(userNameF.getText())) {
								showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(),
										"Error: Usernmae Exists", "Please use different username");

							} else {
								String s = "INSERT INTO sys.Customer (idCustomer, firstName, lastName, streetAddress, city, state, zipCode, email, ssn, userName, password, securityQuestion, securityAnswer) VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?)";
								ps = con.prepareStatement(s);
								ps.setString(1, firstNameF.getText());
								ps.setString(2, lastNameF.getText());
								ps.setString(3, streetF.getText());
								ps.setString(4, cityF.getText());
								ps.setString(5, stateF.getText());
								ps.setString(6, zipCodeF.getText());
								ps.setString(7, emailF.getText());
								ps.setString(8, ssnF.getText());
								ps.setString(9, userNameF.getText());
								ps.setString(10, passwordF.getText());
								ps.setString(11, securityQuestionF.getText());
								ps.setString(12, securityAnswerF.getText());
								ps.executeUpdate();
								
								Alert alert = new Alert(AlertType.INFORMATION);
					            alert.setTitle("Registration Status:");
					            alert.setHeaderText(null);
					            alert.setContentText("You have successfully registered!");
					            alert.showAndWait();
							}
						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		};

		signUpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, signupEvent);

		EventHandler<MouseEvent> backEvent = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (e.getButton() == MouseButton.PRIMARY) {
					try {
						Stage loginStage = new Stage();
						LogIn Login = new LogIn();
						Login.start(loginStage);
						loginStage.show();
						stage.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		};

		backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, backEvent);
	}

	public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}

	public boolean checkUsernameExist(String userName) {
		con = Database.ConnectDB();
		try {
			String s = "SELECT userName FROM sys.Customer WHERE userName = '" + userName + "'";
			statement = con.createStatement();
			rs = statement.executeQuery(s);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}

	}
}
