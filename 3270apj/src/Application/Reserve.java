package Application;

import javafx.beans.property.SimpleIntegerProperty;

public class Reserve {
	SimpleIntegerProperty idReservation;
	SimpleIntegerProperty id;
	SimpleIntegerProperty idFlight;
	SimpleIntegerProperty idSeat;
	
	public Reserve() {
		
	}
	
	public Reserve(Integer idReservation, Integer id, Integer idFlight, Integer idSeat) {
		this.idReservation = new SimpleIntegerProperty(idReservation);
		this.id = new SimpleIntegerProperty(id);
		this.idFlight = new SimpleIntegerProperty(idFlight);
		this.idSeat = new SimpleIntegerProperty(idSeat);			
	}
	
	// Getters and Setters for variables
	
	public int getIdReservation() {
		return idReservation.get();
	}
	
	public void setIdReservation(Integer idReservation) {
		this.idReservation = new SimpleIntegerProperty(idReservation);
	}
	
	public int getID() {
		return id.get();
	}
	
	public void setID(Integer id) {
		this.idReservation = new SimpleIntegerProperty(id);
	}
	
	public int getIdFlight() {
		return idFlight.get();
	}
	
	public void setIdFlight(Integer idFlight) {
		this.idFlight = new SimpleIntegerProperty(idFlight);
	}
	
	public int getIdSeat() {
		return idSeat.get();
	}
	
	public void setIdSeat(Integer idSeat) {
		this.idSeat = new SimpleIntegerProperty(idSeat);
	}
	
}
