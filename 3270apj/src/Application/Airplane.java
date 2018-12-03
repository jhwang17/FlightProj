package Application;

import javafx.beans.property.SimpleIntegerProperty;

public class Airplane {
	SimpleIntegerProperty idAirplane;
	SimpleIntegerProperty firstSeat;
	SimpleIntegerProperty busSeat;
	SimpleIntegerProperty econSeat;
	SimpleIntegerProperty idAirport;
	
	public Airplane() {
		
	}
	
	public Airplane(Integer idAirplane, Integer firstSeat, Integer busSeat, Integer econSeat, Integer idAirport) {
		this.idAirplane = new SimpleIntegerProperty(idAirplane);
		this.firstSeat = new SimpleIntegerProperty(firstSeat);
		this.busSeat = new SimpleIntegerProperty(busSeat);
		this.econSeat = new SimpleIntegerProperty(econSeat);
		this.idAirport = new SimpleIntegerProperty(idAirport);
	}
	
	public int getIdAirplane() {
		return idAirplane.get();
	}
	
	public void setIdAirplane(Integer idAirplane) {
		this.idAirplane = new SimpleIntegerProperty(idAirplane);
	}
	
	public int getFirstSeat() {
		return firstSeat.get();
	}
	
	public void setFirstSeat(Integer firstSeat) {
		this.firstSeat = new SimpleIntegerProperty(firstSeat);
	}
	
	public int getBusSeat() {
		return busSeat.get();
	}
	
	public void setBusSeat(Integer busSeat) {
		this.busSeat = new SimpleIntegerProperty(busSeat);
	}
	
	public int getEconSeat() {
		return econSeat.get();
	}
	
	public void setEconSeat(Integer econSeat) {
		this.econSeat = new SimpleIntegerProperty(econSeat);
	}	
	
	public int getIdAirport() {
		return idAirport.get();
	}
	
	public void setIdAirport(Integer idAirport) {
		this.idAirport = new SimpleIntegerProperty(idAirport);
	}	
}
