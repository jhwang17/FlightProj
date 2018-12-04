package Reservation;

import java.time.LocalDate;

import Application.Customer;
import Application.Flight;
import Data.FlightData;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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

public class FlightView extends Application {
	public static TableColumn idFlightC;
	public static TableColumn departLocationC;
	public static TableColumn arrivalLocationC;
	public static TableColumn departDateC;
	public static TableColumn arrivalDateC;
	public static TableColumn departTimeC;
	public static TableColumn arrivalTimeC;
	public static TableColumn capacityC;
	public static TableColumn layoverC;
	
	public static TextField departLocationA;
	public static TextField arrivalLocationA;
	public static DatePicker departDateA;
	public static DatePicker arrivalDateA;
	public static TextField departTimeA;
	public static TextField arrivalTimeA;
	public static TextField capacityA;
	public static TextField layoverA;
	
	public static TextField idFlightU;
	public static TextField departLocationU;
	public static TextField arrivalLocationU;
	public static DatePicker departDateU;
	public static DatePicker arrivalDateU;
	public static TextField departTimeU;
	public static TextField arrivalTimeU;
	public static TextField capacityU;
	public static TextField layoverU;
	
	public static TextField idFlightD;
	

	public static TableView<Flight> table = new TableView<Flight>();

	Stage flightViewStage;
	
	public static void main(String[] args) {
		launch(args);
	}

	// Table UI
	public void start(Stage stage) {
		flightViewStage = stage;
		Scene scene = new Scene(new Group());
		stage.setTitle("Flight Information");
		stage.setFullScreen(true);

		// Name of the table
		Label label = new Label("APJ - Flight Information");
		label.setFont(Font.font("Arial", FontWeight.BOLD, 24));

		// Create column
		idFlightC = new TableColumn("Flight ID");
		idFlightC.setMinWidth(50);
		idFlightC.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("idFlight"));

		departLocationC = new TableColumn("Depart Location");
		departLocationC.setMinWidth(100);
		departLocationC.setCellValueFactory(new PropertyValueFactory<Flight, String>("departLocation"));

		arrivalLocationC = new TableColumn("Arrival Location");
		arrivalLocationC.setMinWidth(100);
		arrivalLocationC.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalLocation"));
		
		departDateC = new TableColumn("Depart Date");
		departDateC.setMinWidth(100);
		departDateC.setCellValueFactory(new PropertyValueFactory<Flight, String>("departDate"));

		arrivalDateC = new TableColumn("Arrival Date");
		arrivalDateC.setMinWidth(100);
		arrivalDateC.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalDate"));

		departTimeC = new TableColumn("Depart Time");
		departTimeC.setMinWidth(100);
		departTimeC.setCellValueFactory(new PropertyValueFactory<Flight, String>("departTime"));

		arrivalTimeC = new TableColumn("Depart Time");
		arrivalTimeC.setMinWidth(100);
		arrivalTimeC.setCellValueFactory(new PropertyValueFactory<Flight, String>("departTime"));

		capacityC = new TableColumn("Capacity");
		capacityC.setMinWidth(100);
		capacityC.setCellValueFactory(new PropertyValueFactory<Flight, Integer>("capacity"));

		layoverC = new TableColumn("Layover");
		layoverC.setMinWidth(100);
		layoverC.setCellValueFactory(new PropertyValueFactory<Flight, String>("layover"));

		loadTable();

	
		// field for add box
		departLocationA = new TextField();
		departLocationA.setPromptText("Depart Location");
		departLocationA.setMaxWidth(departLocationC.getPrefWidth());

		arrivalLocationA = new TextField();
		arrivalLocationA.setPromptText("Arrival Location");
		arrivalLocationA.setMaxWidth(arrivalLocationC.getPrefWidth());
		
		departDateA = new DatePicker();
		departDateA.setPromptText("Depart Date");
		departDateA.setOnAction(event -> {
			LocalDate date = departDateA.getValue();
		});

		arrivalDateA = new DatePicker();
		arrivalDateA.setPromptText("Arrival Date");
		arrivalDateA.setOnAction(event -> {
			LocalDate date = arrivalDateA.getValue();
		});

		departTimeA = new TextField();
		departTimeA.setPromptText("Depart Time");
		departTimeA.setMaxWidth(departTimeC.getPrefWidth());

		arrivalTimeA = new TextField();
		arrivalTimeA.setPromptText("Arrival Time");
		arrivalTimeA.setMaxWidth(arrivalTimeC.getPrefWidth());

		capacityA = new TextField();
		capacityA.setPromptText("Capacity");
		capacityA.setMaxWidth(capacityC.getPrefWidth());

		layoverA = new TextField();
		layoverA.setPromptText("Layover");
		layoverA.setMaxWidth(layoverC.getPrefWidth());

		//field for update box
		idFlightU = new TextField();
		idFlightU.setPromptText("ID");
		idFlightU.setMaxWidth(idFlightC.getPrefWidth());
		
		departLocationU = new TextField();
		departLocationU.setPromptText("Depart Location");
		departLocationU.setMaxWidth(departLocationC.getPrefWidth());

		arrivalLocationU = new TextField();
		arrivalLocationU.setPromptText("Arrival Location");
		arrivalLocationU.setMaxWidth(arrivalLocationC.getPrefWidth());
		
		departDateU = new DatePicker();
		departDateU.setPromptText("Depart Date");
		departDateU.setOnAction(event -> {
			LocalDate date = departDateU.getValue();
		});

		arrivalDateU = new DatePicker();
		arrivalDateU.setPromptText("Arrival Date");
		arrivalDateU.setOnAction(event -> {
			LocalDate date = arrivalDateU.getValue();
		});

		departTimeU = new TextField();
		departTimeU.setPromptText("Depart Time");
		departTimeU.setMaxWidth(departTimeC.getPrefWidth());

		arrivalTimeU = new TextField();
		arrivalTimeU.setPromptText("Arrival Time");
		arrivalTimeU.setMaxWidth(arrivalTimeC.getPrefWidth());

		capacityU = new TextField();
		capacityU.setPromptText("Capacity");
		capacityU.setMaxWidth(capacityC.getPrefWidth());

		layoverU = new TextField();
		layoverU.setPromptText("Layover");
		layoverU.setMaxWidth(layoverC.getPrefWidth());
		
		// field for delete box
		idFlightD = new TextField();
		idFlightD.setPromptText("ID");
		idFlightD.setMaxWidth(idFlightC.getPrefWidth());

		// Create add button
//		Button addButton = new Button("Add");
//		addButton.setOnAction((event) -> {
//			FlightData.insertFlight();
//		});
		Button addButton = new Button("Add");
		addButton.setOnAction((event) -> {
			if(departDateA.getValue().isAfter(arrivalDateA.getValue())) {
				GridPane alert = new GridPane();
				Scene sc = new Scene(alert, 200, 200);
				showAlert(Alert.AlertType.ERROR, alert.getScene().getWindow(), "Error!",
						"Set dates are not valid");
			} else {
				FlightData.insertFlight();
			}
		});

		//create update button
		Button updateButton = new Button("Update");
		updateButton.setOnAction((event) -> {
			FlightData.updateFlight();
		});
								
		// create delete button
		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction((event) -> {
			FlightData.deleteFlight();
		});
		
		//create back button
		Button backButton = new Button("Back");
		backButton.setOnAction(e -> {
			try {
				Stage adminStage = new Stage();
				AdminStage booking = new AdminStage();
				booking.start(adminStage);
				adminStage.show();
				flightViewStage.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		// create add box
		HBox addBox = new HBox();
		addBox.getChildren().addAll(departLocationA, arrivalLocationA, departDateA, arrivalDateA, departTimeA, arrivalTimeA, capacityA, layoverA, addButton);
		addBox.setSpacing(10);

		//create update box
		HBox updateBox = new HBox();
		updateBox.setSpacing(10);
		updateBox.getChildren().addAll(idFlightU, departLocationU, arrivalLocationU, departDateU, arrivalDateU, departTimeU, arrivalTimeU, capacityU, layoverU, updateButton);
		
		// create delete box
		HBox deleteBox = new HBox();
		deleteBox.setSpacing(10);
		deleteBox.getChildren().addAll(idFlightD, deleteButton);

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

	// Load the table
	public static void loadTable() {
		ObservableList<Flight> data = FlightData.getFlight();
		table.getColumns().addAll(idFlightC, departLocationC, arrivalLocationC, departDateC, arrivalDateC, departTimeC, arrivalTimeC, capacityC, layoverC);
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
