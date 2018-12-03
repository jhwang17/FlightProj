package Application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Airport {
	SimpleIntegerProperty idAirport;
	SimpleStringProperty airportName;
	SimpleStringProperty country;
	SimpleStringProperty city;
	SimpleStringProperty state;
	
	public Airport() {
		
	}
	
	public Airport(Integer idAirport, String airportName, String country,
				  String city, String state) {
		
		this.idAirport = new SimpleIntegerProperty(idAirport);
		this.airportName = new SimpleStringProperty(airportName);
		this.country = new SimpleStringProperty(country);
		this.city = new SimpleStringProperty(city);
		this.state = new SimpleStringProperty(state);
	}
	
	public int getIdAirport() {
		return idAirport.get();
	}
	
	public void setIdAirport(Integer idAirport) {
		this.idAirport = new SimpleIntegerProperty(idAirport);
	}	
	
	public String getAirportName() {
		return airportName.get();
	}
	
	public void setAirportName(String airportName) {
		this.airportName = new SimpleStringProperty(airportName);
	}
	
	public String getCountry() {
		return country.get();
	}
	
	public void setCountry(String country) {
		this.country = new SimpleStringProperty(country);
	}
	
	public String getCity() {
		return city.get();
	}
	
	public void setCity(String city) {
		this.city = new SimpleStringProperty(city);
	}
	
	public String getState() {
		return state.get();
	}
	
	public void setState(String state) {
		this.state = new SimpleStringProperty(state);
	}
	
	
	
}
