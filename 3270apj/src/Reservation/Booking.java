package Reservation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import Application.Flight;
import Data.Database;
import Data.FlightData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;

public abstract class Booking extends Application {
	
	public static final double WIDTH = 750;
	public static final double HEIGHT = 400;
	
	Stage bookingStage, warningStage;
	BorderPane leftLayout;
	VBox botLayout, topLayout, rightLayout;
	
	Button backBtn, clearBtn, searchBtn, sortBtn, reserveBtn, myFlightsBtn;
	ToggleGroup travelType;
	RadioButton oneWay, roundTrip;
	Button setSortBtn;

	ToggleGroup sortOptions;
	RadioButton sortPrice, sortTime, sortClass;
	TextField fromF, toF;
	DatePicker departureDate, arrivalDate;
	ComboBox dropList;
	
	// Flights
	FlightData flightDB;
	ObservableList<Flight> flightList;
	ObservableList<Flight> searchList;
	
	// Database variables
	Database db;
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		bookingStage = stage;
		flightDB = new FlightData();
		flightList = flightDB.getFlight();
		
		backBtn = new Button();
		clearBtn = new Button();
		searchBtn = new Button();
		sortBtn = new Button();
		reserveBtn = new Button();
		myFlightsBtn = new Button();
		setSortBtn = new Button();
		
		rightLayout();
		leftLayout();

		HBox root = new HBox();
		root.getChildren().addAll(leftLayout, rightLayout);
		
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		stage.setScene(scene);
		stage.setTitle("Book a flight!");
		stage.setResizable(false);
		stage.show();
	}
	
	public void rightLayout() {
		rightLayout = new VBox();
		
		rightLayout.setPrefSize(WIDTH / 2, HEIGHT / 2);
	}
	
	public void leftLayout() {
		leftLayout = new BorderPane();
		leftLayout.setPrefSize(WIDTH / 2, HEIGHT / 2);
		leftLayout.setStyle("-fx-border-width: 0px 2px 0px 0px; -fx-border-color: black");
		
		topLayout = new VBox();
		botLayout = new VBox();
		
		topLayout = topLeftDefault();
		botLayout = bottomLeftDefault();
		
		leftLayout.setTop(topLayout);
		leftLayout.setBottom(botLayout);
	}
	
	//Default display for quadrant 2
	public VBox topLeftDefault() {
		// Creates layout frame for the top left section
		VBox layout = new VBox();
		layout.setPadding(new Insets(5, 0, 5, 0));
		
		// Creates/Adds boarding options (one way/round trip)
		HBox boardingOptions = new HBox();
		boardingOptions.setAlignment(Pos.CENTER);
		boardingOptions.setPadding(new Insets(10, 0, 10, 0));
		boardingOptions.setSpacing(30);
		
		travelType = new ToggleGroup();
		
		// One way Trip
		RadioButton oneWay = new RadioButton();
		oneWay.setText("One Way");
		oneWay.setFont(new Font("Arial", 18));
		oneWay.setToggleGroup(travelType);
		
		// Round Trip
		RadioButton roundTrip = new RadioButton();
		roundTrip.setText("Round Trip");
		roundTrip.setFont(new Font("Arial", 18));
		roundTrip.setToggleGroup(travelType);
		
		boardingOptions.getChildren().addAll(oneWay, roundTrip);
		
		// Creates/Adds flight location and date options (From/To/Departure/Arrival)
		GridPane locationOptions = new GridPane();
		locationOptions.setPadding(new Insets(5, 0, 5, 0));
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date today = new Date();
		
		// Departure location
		Label fromL = new Label();
		fromL.setText("From: ");
		fromL.setAlignment(Pos.CENTER_RIGHT);
		fromL.setPrefWidth(115);
		fromL.setFont(new Font("Arial", 22));
		locationOptions.add(fromL, 0, 0);
		fromF = new TextField();
		locationOptions.add(fromF, 1, 0);
		
		// Arrival location 
		Label toL = new Label();
		toL.setText("To: ");
		toL.setAlignment(Pos.CENTER_RIGHT);
		toL.setPrefWidth(115);
		toL.setFont(new Font("Arial", 22));
		locationOptions.add(toL, 0, 1);
		toF = new TextField();
		locationOptions.add(toF, 1, 1);
		
		// Departing date
		Label departL = new Label();
		departL.setText("Departure: ");
		departL.setFont(new Font("Arial", 20));
		departL.setAlignment(Pos.CENTER_RIGHT);
		departL.setPrefWidth(115);
		locationOptions.add(departL, 0, 2);
		
		departureDate = new DatePicker();
		departureDate.setPromptText(dateFormat.format(today).toString());
		locationOptions.add(departureDate, 1, 2);
		
		// Arrival date
		Label returnL = new Label();
		returnL.setText("Return: ");
		returnL.setFont(new Font("Arial", 20));
		returnL.setAlignment(Pos.CENTER_RIGHT);
		returnL.setPrefWidth(115);
		locationOptions.add(returnL, 0, 3);
		
		arrivalDate = new DatePicker();
		arrivalDate.setPromptText(dateFormat.format(today).toString());
		locationOptions.add(arrivalDate, 1, 3);
		
		// Creates/Adds number of passengers options 
		HBox passengerOptions = new HBox();
		passengerOptions.setPadding(new Insets(5, 0, 5, 10));
		
		Label passengerL = new Label();
		passengerL.setText("Number of Passengers: ");
		passengerL.setFont(new Font("Arial", 22));
		
		// Creates combo box (drop list) of options
		ObservableList<String> options = FXCollections.observableArrayList(
				"1", "2", "3", "4", "5", "6", "7", "8", "9"
				);
		dropList = new ComboBox(options);
		dropList.setPromptText(options.get(0));
		passengerOptions.getChildren().addAll(passengerL, dropList);
		
		layout.getChildren().addAll(boardingOptions, locationOptions, passengerOptions);
		
		return layout;
	}

	// Default display for quadrant3

	protected VBox bottomLeftDefault() {
		VBox layout = new VBox();
		layout.setSpacing(10);
		
		HBox row1 = new HBox();
		row1.setPrefWidth(WIDTH / 2);
		row1.setAlignment(Pos.CENTER);
		row1.setSpacing(20);
		
		clearBtn.setText("Clear");
		clearBtn.setFont(new Font("Arial", 20));
		
		searchBtn.setText("Search");
		searchBtn.setFont(new Font("Arial", 20));
		
		sortBtn.setText("Sort By");
		sortBtn.setFont(new Font("Arial", 20));
		
		row1.getChildren().addAll(clearBtn, searchBtn, sortBtn);
		
		HBox row2 = new HBox();
		row2.setAlignment(Pos.CENTER);
		row2.setPrefWidth(WIDTH / 2);
		
		reserveBtn = new Button();
		reserveBtn.setText("Reserve");
		reserveBtn.setFont(new Font("Arial", 20));
		reserveBtn.setPrefWidth((WIDTH / 2) - 150);
		
		row2.getChildren().add(reserveBtn);
		
		HBox row3 = new HBox();

		row3 = userSettings();
		
		layout.getChildren().addAll(row1, row2, row3);
		
		clearTrigger();
		searchTrigger();
		sortTrigger();
		reserveTrigger();
		
		return layout;
	}
	
	// Sort Button
	private VBox sortLayout() {
		VBox layout = new VBox();
		layout.setPadding(new Insets(0, 5, 0, 5));
		layout.setSpacing(2);
		
		HBox top = new HBox();
		top.setAlignment(Pos.CENTER);
		Label text = new Label();
		text.setText("Sort search by");
		text.setFont(new Font("Arial", 20));
		top.getChildren().add(text);
		
		sortOptions = new ToggleGroup();
		
		sortPrice = new RadioButton();
		sortPrice.setText("Price");
		sortPrice.setToggleGroup(sortOptions);
		sortTime = new RadioButton();
		sortTime.setText("Time");
		sortTime.setToggleGroup(sortOptions);
		sortClass = new RadioButton();
		sortClass.setText("Class");
		sortClass.setToggleGroup(sortOptions);
		
		HBox bottom = new HBox();
		bottom.setAlignment(Pos.CENTER_RIGHT);
		bottom.setPadding(new Insets(0, 0, 5, 0));
		setSortBtn.setText("Search");
		bottom.getChildren().add(setSortBtn);
		
		layout.getChildren().addAll(top, sortPrice, sortTime, sortClass, bottom);
		
		setSortTrigger();
		
		return layout;
	}
	
	// Back button Trigger
	protected void backTrigger() {
		backBtn.setOnAction(e -> {
			LogIn nextStage = new LogIn();
			Warning warningStage = new Warning(bookingStage, nextStage);
			warningStage.show();
		});
	}
	
	// Clear button Trigger
	private void clearTrigger() {
		clearBtn.setOnAction(e -> {
			travelType.selectToggle(null);
			fromF.clear();
			toF.clear();
			departureDate.setValue(null);
			arrivalDate.setValue(null);
			dropList.setValue(null);
		});
	}
	
	private void searchTrigger() {
		//FXCollections.copy(searchList, flightList);
		
		searchBtn.setOnAction(e -> {
			if(fromF.getText().isEmpty() || toF.getText().isEmpty() || !departureDate.hasProperties() || !arrivalDate.hasProperties()) {
				GridPane alert = new GridPane();
				Scene sc = new Scene(alert, 200, 200);
				showAlert(Alert.AlertType.ERROR, alert.getScene().getWindow(), "Error",
						"Please fill in empty fields");
			} else if(departureDate.getValue().isAfter(arrivalDate.getValue())) {
				GridPane alert = new GridPane();
				Scene sc = new Scene(alert, 200, 200);
				showAlert(Alert.AlertType.ERROR, alert.getScene().getWindow(), "Error",
						"Set dates are not valid");
			} else {
				for(int i = 0; i < flightList.size(); i++) {
					if(!searchList.get(i).getDepartLocation().matches(fromF.toString()) 
							&& !searchList.get(i).getArrivalLocation().matches(toF.toString())) {
						searchList.remove(i);
					}
					
					if(!searchList.get(i).getDepartDate().matches(departureDate.toString()) 
							&& !searchList.get(i).getArrivalDate().matches(arrivalDate.toString())) {
						searchList.remove(i);
					}
				}
				rightLayout.getChildren().add(searchFlights());
			}
			
		});
	}
	
	private void sortTrigger() {
		sortBtn.setOnAction(e -> {
			leftLayout.setBottom(sortLayout());
		});
	}
	
	
	protected void myFlightsTrigger() {
		
	}
	
	private void setSortTrigger() {
		setSortBtn.setOnAction(e -> {
			Comparator<Flight> comparator = Comparator.comparing(Flight::getIdFlight);
			
			if(sortPrice.isPressed()) {
				comparator = Comparator.comparingDouble(Flight::getPrice);
			} else if(sortTime.isPressed()) {
				comparator = Comparator.comparing(Flight::getDepartTime);
			} else if(sortClass.isPressed()) {
				comparator = Comparator.comparing(Flight::getPrice);
			} else {
				comparator = Comparator.comparing(Flight::getIdFlight);
			}
			
			FXCollections.sort(flightList, comparator);
			searchBtn.arm();
			leftLayout.setBottom(bottomLeftDefault());
		});
	}
	
	public abstract HBox userSettings();
	
	public abstract void reserveTrigger();
	
	private VBox searchFlights() {
		VBox layout = new VBox();
		
		double height = 0;
		for(int i = 0; i < searchList.size(); i++) {
			layout.getChildren().add(searchList.get(i).flightLayout());
			height += searchList.get(i).flightLayout().getHeight();
		}
		
		if(rightLayout.getHeight() < height) {
			ScrollBar s = new ScrollBar();
			s.setMin(rightLayout.getHeight());
			s.setMax(height);
//			s.setMin(0);
//			s.setMax(HEIGHT / 2);
			s.setOrientation(Orientation.VERTICAL);
			s.setValue(110);
			s.setUnitIncrement(12);
			s.setBlockIncrement(10);
			
			StackPane root = new StackPane();
			root.getChildren().add(s);
			
			layout.getChildren().add(root);
		} else {
			
		}
		System.out.println(height);
		return layout;
	}
	
	public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.initOwner(owner);
		alert.show();
	}
}

class CustomerStage extends Booking {

	@Override
	public HBox userSettings() {
		HBox row3 = new HBox();
		row3.setAlignment(Pos.CENTER);
		row3.setPrefWidth(WIDTH / 2);
		row3.setSpacing(100);
		
		backBtn.setText("Back");
		backBtn.setFont(new Font("Arial", 20));
		
		myFlightsBtn.setText("My Flights");
		myFlightsBtn.setFont(new Font("Arial", 20));
		
		row3.getChildren().addAll(backBtn, myFlightsBtn);
		
		super.backTrigger();
		super.myFlightsTrigger();
		
		return row3;
	}
	

	@Override
	public void reserveTrigger() {
		// TODO Auto-generated method stub
		
	}
	
}

class AdminStage extends Booking {
	
	Button admSettingsBtn, viewFlightBtn, viewUsersBtn, admBackBtn;
	
	AdminStage() {
		admSettingsBtn = new Button();
		viewFlightBtn = new Button(); 
		viewUsersBtn = new Button();
		admBackBtn = new Button();
	}

	@Override
	public HBox userSettings() {
		HBox row3 = new HBox();
		row3.setAlignment(Pos.CENTER);
		row3.setPrefWidth(WIDTH / 2);
		row3.setSpacing(25);
		
		backBtn.setText("Back");
		backBtn.setFont(new Font("Arial", 18));
		
		
		admSettingsBtn = new Button();
		admSettingsBtn.setText("Admin Settings");
		admSettingsBtn.setFont(new Font("Arial", 18));
		
		myFlightsBtn.setText("My Flights");
		myFlightsBtn.setFont(new Font("Arial", 18));
		
		row3.getChildren().addAll(backBtn, admSettingsBtn, myFlightsBtn);
		
		super.backTrigger();
		admSettingsTrigger();
		super.myFlightsTrigger();
		
		return row3;
	}
	
	// Admin Settings
	private VBox adminSettings() {
		VBox layout = new VBox();
		layout.setAlignment(Pos.CENTER);
		layout.setSpacing(10);
		
		viewFlightBtn.setText("Edit Flights");
		viewFlightBtn.setFont(new Font("Arial", 18));
		viewUsersBtn.setText("Edit Customers");
		viewUsersBtn.setFont(new Font("Arial", 18));
		admBackBtn.setText("Back");
		admBackBtn.setFont(new Font("Arial", 18));
		
		layout.getChildren().addAll(viewFlightBtn, viewUsersBtn,admBackBtn);
		
		viewFlightTrigger();
		viewUsersTrigger();
		admBackTrigger();
		
		return layout;
	}
	
	private void admSettingsTrigger() {
		admSettingsBtn.setOnAction(e -> {
			leftLayout.setBottom(adminSettings());
		});
	}
	
	private void viewFlightTrigger() {
		viewFlightBtn.setOnAction(e -> {
			Stage stage = new Stage();
			FlightView nextStage = new FlightView();
			nextStage.start(stage);
			bookingStage.close();
		});
	}
	
	private void viewUsersTrigger() {
		viewUsersBtn.setOnAction(e -> {
			Stage stage = new Stage();
			CustomerView nextStage = new CustomerView();
			nextStage.start(stage);
			bookingStage.close();
			/*
			Warning warningStage = new Warning(bookingStage, nextStage);
			warningStage.show();
			*/
		});
	}
	
	private void admBackTrigger() {
		admBackBtn.setOnAction(e -> {
			leftLayout.setBottom(bottomLeftDefault());
		});
	}

	
	@Override
	public void reserveTrigger() {
		// TODO Auto-generated method stub
		
	}
}
