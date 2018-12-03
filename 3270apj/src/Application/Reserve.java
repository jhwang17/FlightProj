package Application;

import javafx.beans.property.SimpleIntegerProperty;

public class Reserve {
	SimpleIntegerProperty idReservation;
	SimpleIntegerProperty idCustomer;
	SimpleIntegerProperty idFlight;
	SimpleIntegerProperty idSeat;
	
	public Reserve() {
		
	}
	
	public Reserve(Integer idReservation, Integer idCustomer, Integer idFlight, Integer idSeat) {
		this.idReservation = new SimpleIntegerProperty(idReservation);
		this.idCustomer = new SimpleIntegerProperty(idCustomer);
		this.idFlight = new SimpleIntegerProperty(idFlight);
		this.idSeat = new SimpleIntegerProperty(idSeat);			
	}
	
	public int getIdReservation() {
		return idReservation.get();
	}
	
	public void setIdReservation(Integer idReservation) {
		this.idReservation = new SimpleIntegerProperty(idReservation);
	}
	
	public int getIdCustomer() {
		return idCustomer.get();
	}
	
	public void setIdCustomer(Integer idCustomer) {
		this.idReservation = new SimpleIntegerProperty(idCustomer);
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
