package Reservation;

import Application.Admin;
import Application.Customer;
import Data.AdminData;
import Data.CustomerData;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LogIn extends Application {
	
	Stage loginStage;
	public static int userID;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) {
		loginStage = stage;
		
		GridPane gridPane = createLogInFormPane();
		addUIControls(gridPane);
		Scene scene = new Scene(gridPane, 300, 275);
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(500);
		stage.setTitle("Welcome");
		stage.show();
		}
	
	// Sets Layout 
	public GridPane createLogInFormPane() {
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		return gridPane;
	}	
	
	// Sets UI control
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
	
		 EventHandler<MouseEvent> loginEvent = new EventHandler<MouseEvent>() {
	         public void handle(MouseEvent e) {
				 if(e.getButton() == MouseButton.PRIMARY) {
					if(checkCridentialsAdmin(userNameF.getText(),passwordF.getText())) {
						try {
							Stage adminStage = new Stage();
							AdminStage booking = new AdminStage();
							booking.start(adminStage);
							adminStage.show();
							loginStage.close();
						} catch(Exception ex) {
							ex.printStackTrace();			
						}
					} else if(checkCridentialsUser(userNameF.getText(),passwordF.getText())) {
						 try {
    				 		Stage customerStage = new Stage();
    				 		CustomerStage booking = new CustomerStage();
    				 		booking.start(customerStage);
    				 		customerStage.show();
    				 		loginStage.close();
        			 	}catch(Exception ex) {
        			 		ex.printStackTrace();
        			 	}
					 } else {
						 showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Login Error!",
														"Incorrect Username or Password");
					 }
				 }

			 }
		 };

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
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	};
	
	registerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, registerEvent);
	
	EventHandler<MouseEvent> forgetEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent e) {
			if(e.getButton() == MouseButton.PRIMARY) {
				try {
					Stage forgetStage = new Stage();
					ForgetPassword forget = new ForgetPassword();
					forget.start(forgetStage);
					forgetStage.show();
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	};
		forgetPasswordButton.addEventHandler(MouseEvent.MOUSE_CLICKED, forgetEvent);
	}
		
	// Checks if username and password matches a Customer 
	boolean checkCridentialsUser(String userName,String password) {
		ObservableList<Customer> customers = CustomerData.getCustomer();

		if(customers.isEmpty()) {
			return false;		
		} else {
			for(Customer c:customers) {
				if(userName.equals(c.getUserName())  ) {
					System.out.println("Username: "+c.getUserName()+" Password: "+c.getPassword());
					if(password.equals(c.getPassword())) {
						Booking.userC = c;
						return true;
					} else {
						return false;
					}
				}
			}
			return false;
		}
	}
	
	// Checks if username and password matches an Admin 
	boolean checkCridentialsAdmin(String userName,String password) {
		ObservableList<Admin> admins = AdminData.getAdmin();
		for(Admin a:admins) {
			if(userName.equals(a.getUserName())  ) {
				System.out.println("Username: "+a.getUserName()+" Password: "+a.getPassword());
				if(password.equals(a.getPassword())) {
					Booking.userA = a;
					return true;
				}
				else {
					return false;
				}
			}
		}
		return false;
	}
	
	// Sets alert popup window
	public void showAlert(Alert.AlertType alertType,Window owner,String title,String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}
