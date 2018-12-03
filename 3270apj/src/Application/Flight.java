package Application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Flight {

	SimpleIntegerProperty idFlight;
	SimpleStringProperty departLocation;
	SimpleStringProperty arrivalLocation;
	SimpleStringProperty departDate;
	SimpleStringProperty arrivalDate;
	SimpleStringProperty departTime;
	SimpleStringProperty arrivalTime;
	SimpleIntegerProperty capacity;
	SimpleStringProperty layover;
	SimpleIntegerProperty idAirport;
	SimpleIntegerProperty idAirplane;
	
	public Flight() {
		
	}
	
	public VBox flightLayout() {
		VBox layout = new VBox();
		layout.setPrefSize(150, 200);
		layout.setStyle("-fx-border-width: 0.5px, 0.5px, 0.5px, 0px; -fx-border-color: black");
		
		//Label idLabel = new Label();
		//idLabel.setText(this.idFlight.toString());
		Label departDLabel = new Label();
		departDLabel.setText("Depart: " + this.departDate.getName());
		Label arrivalDLabel = new Label();
		arrivalDLabel.setText("Arrive: " + this.arrivalDate.toString());
		Label  departTLabel = new Label();
		departTLabel.setText("Depart Time: " + departTime.toString());
		Label arrivalTLabel = new Label();
		arrivalTLabel.setText("Arrive Time: " + arrivalTime.toString());
		Label capLabel = new Label();
		capLabel.setText("Seat Cap.: " + capacity.getValue().toString());
		Label layoverLabel = new Label();
		layoverLabel.setText(layover.getValue());
		
		//Possibly don't need to include flightID and capacity for viewers??
		//Needs depart/arrival cities and number of seats available 
		
		
		layout.getChildren().addAll(departDLabel, arrivalDLabel, departTLabel, arrivalTLabel, capLabel, layoverLabel);
		return layout;
	}
	
	public Flight(Integer idFlight, String departLocation, String arrivalLocation,
				  String departDate, String arrivalDate, String departTime, 
				  String arrivalTime, Integer capacity, String layover) {
		
		this.idFlight = new SimpleIntegerProperty(idFlight);
		this.departLocation = new SimpleStringProperty(departLocation);
		this.arrivalLocation = new SimpleStringProperty(arrivalLocation);
		this.departDate = new SimpleStringProperty(departDate);
		this.arrivalDate = new SimpleStringProperty(arrivalDate);
		this.departTime = new SimpleStringProperty(departTime);
		this.arrivalTime = new SimpleStringProperty(arrivalTime);
		this.capacity = new SimpleIntegerProperty(capacity);
		this.layover = new SimpleStringProperty(layover);
	}
	
	public int getIdFlight() {
		return idFlight.get();
	}
	
	public void setIdFlight(Integer idFlight) {
		this.idFlight = new SimpleIntegerProperty(idFlight);
	}
	
	public String getDepartLocation() {
		return departLocation.get();
	}
	
	public void setDepartLocation(String departLocation) {
		this.departLocation = new SimpleStringProperty(departLocation);
	}
	
	public String getArrivalLocation() {
		return arrivalLocation.get();
	}
	
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = new SimpleStringProperty(arrivalLocation);
	}
	
	public String getDepartDate() {
		return departDate.get();
	}
	
	public void setDepartDate(String departDate) {
		this.departDate = new SimpleStringProperty(departDate);
	}
	
	public String getArrivalDate() {
		return arrivalDate.get();
	}
	
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = new SimpleStringProperty(arrivalDate);
	}
	
	public String getDepartTime() {
		return departTime.get();
	}
	
	public void setDepartTime(String departTime) {
		this.departTime = new SimpleStringProperty(departTime);
	}
	
	public String getArrivalTime() {
		return arrivalTime.get();
	}
	
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = new SimpleStringProperty(arrivalTime);
	}
	
	public int getCapacity() {
		return capacity.get();
	}
	
	public void setCapacity(int capacity) {
		this.capacity = new SimpleIntegerProperty(capacity);
	}
	
	public String getLayover() {
		return layover.get();
	}
	
	public void setLayover(String layover) {
		this.layover = new SimpleStringProperty(layover);
	}
	
	public int getIdAirport() {
		return idAirport.get();
	}
	
	public void setIdAirport(Integer idAirport) {
		this.idAirport = new SimpleIntegerProperty(idAirport);
	}
	
	public int getIdAirplane() {
		return idAirplane.get();
	}
	
	public void setIdAirplane(Integer idAirplane) {
		this.idAirplane = new SimpleIntegerProperty(idAirplane);
	}
	
	@Override
    public String toString() {
        return "Flight{" +
                "idFlight=" + idFlight +
                ", departDate=" + departLocation +
                ", arrivalDate=" + arrivalLocation +
                ", departDate=" + departDate +
                ", arrivalDate=" + arrivalDate +
                ", departTime=" + departTime +
                ", arrivalTime=" + arrivalTime +
                ", capacity" + capacity +
                ", layover" + layover +
                '}';
	}	
}

