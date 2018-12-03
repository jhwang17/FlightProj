package Reservation;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import Data.CustomerData;
import Application.Customer;
import java.util.ArrayList;


public class LogIn extends Application {
	public static void main(String[] args) {
		launch(args);
		}
	
	public void start(Stage stage) {
		GridPane gridPane = createLogInFormPane();
		addUIControls(gridPane);
		Scene scene = new Scene(gridPane, 300, 275);
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(500);
		stage.setTitle("Welcome");
		stage.show();
		}
	
	public GridPane createLogInFormPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		return gridPane;
		}	
	
	public void addUIControls(GridPane gridPane) {
		//Header
		Label headerLabel = new Label("APJ - Log In");
		headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 35));
		gridPane.add(headerLabel, 0, 0, 2, 1);
		GridPane.setHalignment(headerLabel, HPos.CENTER);
		GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

		Label userNameL = new Label("Username:");
		gridPane.add(userNameL, 0, 1);
		TextField userNameF = new TextField();
		gridPane.add(userNameF, 1, 1);

		Label passwordL = new Label("Password:");
		gridPane.add(passwordL, 0, 2);
		PasswordField passwordF = new PasswordField();
		gridPane.add(passwordF, 1, 2);
		
		Button logInButton = new Button("Log in");
		HBox h1 = new HBox();
		h1.setAlignment(Pos.BOTTOM_LEFT);
		h1.getChildren().add(logInButton);
		gridPane.add(h1, 0, 4);
		
		Button forgetPasswordButton = new Button("Forget Password");
		HBox h2 = new HBox();
		h2.setAlignment(Pos.BOTTOM_CENTER);
		h2.getChildren().add(forgetPasswordButton);
		gridPane.add(h2, 1, 4);
		
		Button registerButton = new Button("Register");
		HBox h3 = new HBox();
		h3.setAlignment(Pos.BOTTOM_RIGHT);
		h3.getChildren().add(registerButton);
		gridPane.add(h3, 2, 4);
		
		
		final Text actiontarget = new Text();
		gridPane.add(actiontarget, 1, 6);
		/*
		logInButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				actiontarget.setFill(Color.FIREBRICK);
		    }
		});*/
	
		 EventHandler<MouseEvent> loginEvent = new EventHandler<MouseEvent>() {
	         public void handle(MouseEvent e) {
				 if(e.getButton() == MouseButton.PRIMARY) {
					 if(checkCridentialsAdmin(userNameF.getText(),passwordF.getText())) {
							try {
								Stage adminStage = new Stage();
								AdminStage booking = new AdminStage();
								booking.start(adminStage);
								adminStage.show();
								}catch(Exception ex) {
										
								}
					}
					 else if(checkCridentialsUser(userNameF.getText(),passwordF.getText())) {
						 try {
        				 		Stage loginStage = new Stage();
        				 		CustomerStage booking = new CustomerStage();
        				 		booking.start(loginStage);
        				 		loginStage.show();
				
        			 		}catch(Exception ex) {

        			 		}
					 }

					 
        		 
			
					 else {
						 showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Login Error!",
														"Incorrect Username or Password");
					 }
				 }

			 }
		 };
	         /* Annie	
        				try {
                				if (userNameF.getText().isEmpty() || passwordF.getText().isEmpty()) {
                	
                					showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), 
                							"Login Error!", "Incorrect Username or Password");
                					
                				} else if (checkCridentials(userNameF.getText(),passwordF.getText())) {				
                					Stage loginStage = new Stage();
                					Booking booking = new Booking();
                					booking.start(loginStage);
                					loginStage.show();
             
                				} else if (userNameF.getText().equalsIgnoreCase("admin") && passwordF.getText().equalsIgnoreCase("admin")) {
                					Stage loginStage = new Stage();
                					Booking booking = new Booking();
                					booking.start(loginStage);
                					loginStage.show();
                				}
                				}catch(Exception ex) {
            						ex.printStackTrace();
                			}	
                		}
                	}
                };*/
     logInButton.addEventHandler(MouseEvent.MOUSE_CLICKED, loginEvent);

	EventHandler<MouseEvent> registerEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e) {
			if(e.getButton() == MouseButton.PRIMARY) {
				try {
					Stage registerStage = new Stage();
					SignUpForm signUpForm = new SignUpForm();
					signUpForm.start(registerStage);
					registerStage.show();
					}catch(Exception ex) {

					}
			}
		}
	};
	registerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, registerEvent);
		 }
		

	boolean checkCridentialsUser(String userName,String password) {
		ObservableList<Customer> customers = CustomerData.getCustomer();

		if(customers.isEmpty()) {
			return false;		}
		else {
			for(Customer c:customers) {
				if(c.getUserName() == (userName) ) {
					if(password.equals(c.getPassword())) {
						return true;
					}
					else {
						return false;
					}
				}
			}
			return false;
		}
	}
	boolean checkCridentialsAdmin(String userName,String password){
				if(userName.equalsIgnoreCase("Admin") ) {
					if(password.equalsIgnoreCase("Admin")) {
						return true;
					}
					else {
						return false;
					}
				}
			return false;

	}
	
	
	
		/*Annie
		for(Customer c:customers) {
			if (c.getUserName().equals(userName) && c.getPassword().equals(password)) {
					return true;					
			}
		}
		return false;
	}*/
	public void showAlert(Alert.AlertType alertType,Window owner,String title,String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}

