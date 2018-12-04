package Data;

import Application.Flight;
import Reservation.Booking;
import Reservation.FlightView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import java.sql.*;

public class FlightData {
	static ObservableList<Flight> flights; 
	static Connection con;
	static ResultSet rs;
	static Statement statement;
	static PreparedStatement ps;

	public static ObservableList<Flight> getFlight() {
		
		//show customer data
		flights = FXCollections.observableArrayList();
		con = Database.ConnectDB();
		try {
			String s = "SELECT idFlight, departLocation, arrivalLocation, departDate, arrivalDate, departTime, arrivalTime, capacity, openSeats, layover FROM sys.Flight";
			statement = con.createStatement();
			rs = statement.executeQuery(s);
            if(rs != null) {
                while (rs.next()) {
                	Flight flight = new Flight();
                	flight.setIdFlight(rs.getInt(1));
                	flight.setDepartLocation(rs.getString(2));
                	flight.setArrivalLocation(rs.getString(3));
                	flight.setDepartDate(rs.getString(4));
                	flight.setArrivalDate(rs.getString(5));
                	flight.setDepartTime(rs.getString(6));
                	flight.setArrivalTime(rs.getString(7));
                	flight.setCapacity(rs.getInt(8));
                	flight.setOpenSeats(rs.getInt(9));
                	flight.setLayover(rs.getString(10));
                	
                	flights.add(flight);
                }
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flights;
	}
	
	public static void deleteReservedFlight(String type, int id) {
		try {
        	//Delete flight info in table
        	String s = "DELETE FROM sys.Reservation WHERE idFlight=? and id="+ id;
        	ps = con.prepareStatement(s);
        	ps.setString(1, Booking.myFlightIdCancel.getText());
        	
			ps.executeUpdate();
        	
        	Booking.table.getColumns().clear();
			Booking.table.getItems().clear();
			//Booking.myFlights();
			
			Booking.myFlightIdCancel.clear();
			
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	public static ObservableList<Flight> getReservedFlight(String type, int id) {
		
		//show customer data
		flights = FXCollections.observableArrayList();
		con = Database.ConnectDB();
		try {
			String s = "SELECT sys.Reservation.idFlight, departLocation, arrivalLocation, departDate, arrivalDate, departTime, arrivalTime, "
					+ "capacity, openSeats, layover FROM sys.Flight inner join sys.Reservation on sys.Reservation.idFlight = sys.flight.idFlight "
					+ "where id=" + id;
			statement = con.createStatement();
			rs = statement.executeQuery(s);
            if(rs != null) {
                while (rs.next()) {
                	Flight flight = new Flight();
                	flight.setIdFlight(rs.getInt(1));
                	flight.setDepartLocation(rs.getString(2));
                	flight.setArrivalLocation(rs.getString(3));
                	flight.setDepartDate(rs.getString(4));
                	flight.setArrivalDate(rs.getString(5));
                	flight.setDepartTime(rs.getString(6));
                	flight.setArrivalTime(rs.getString(7));
                	flight.setCapacity(rs.getInt(8));
                	flight.setOpenSeats(rs.getInt(9));
                	flight.setLayover(rs.getString(10));
                	
                	flights.add(flight);
                }
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return flights;
	}
	
	// Updates open seats when reserving
	public static void updateSeats(int idFlight, int numOfPass) {
		try {
        	//Delete flight info in table
        	String s = "UPDATE sys.Flight SET openSeats=(openSeats+?) WHERE idFlight="+ idFlight;
        	ps = con.prepareStatement(s);
        	ps.setString(1, numOfPass + "");
        	
			ps.executeUpdate();
        	/*
        	Booking.table.getColumns().clear();
			Booking.table.getItems().clear();
			Booking.myFlights();
			
			Booking.myFlightIdCancel.clear();
			*/
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	//method to add a flight
    public static void insertFlight() {
        try {
        	if (FlightView.departLocationA.getText().isEmpty() ||
        		FlightView.arrivalLocationA.getText().isEmpty() ||
            	FlightView.departDateA.getEditor().getText().isEmpty() ||	
        		FlightView.arrivalDateA.getEditor().getText().isEmpty() ||
        		FlightView.departTimeA.getText().isEmpty() ||
        		FlightView.arrivalTimeA.getText().isEmpty() ||
        		FlightView.capacityA.getText().isEmpty() ||
        		FlightView.openSeatsA.getText().isEmpty() ||
        		FlightView.layoverA.getText().isEmpty()) {
        		return; //stops the insert
        	}
        	
        	//Add flight to table
        	String s = "INSERT INTO sys.Flight (idFlight, departLocation, arrivalLocation, departDate, arrivalDate, departTime, arrivalTime, capacity, openSeats, layover) VALUES (default,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(s);
			ps.setString(1, FlightView.departLocationA.getText());
			ps.setString(2, FlightView.arrivalLocationA.getText());
			ps.setString(3, FlightView.departDateA.getEditor().getText());
			ps.setString(4, FlightView.arrivalDateA.getEditor().getText());
			ps.setString(5, FlightView.departTimeA.getText());
			ps.setString(6, FlightView.arrivalTimeA.getText());
			ps.setString(7, FlightView.capacityA.getText());
			ps.setString(8, FlightView.openSeatsA.getText());
			ps.setString(9, FlightView.layoverA.getText());
			
			ps.executeUpdate();
			
			FlightView.table.getColumns().clear();
			FlightView.table.getItems().clear();
			FlightView.loadTable();
			
			FlightView.departLocationA.clear();
			FlightView.arrivalLocationA.clear();
			FlightView.departTimeA.clear();
			FlightView.arrivalTimeA.clear();
			FlightView.capacityA.clear();
			FlightView.openSeatsA.clear();
			FlightView.layoverA.clear();
			
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //method to update a flight
    public static void updateFlight() {
        try {
        	//Update flight info to table        			
        	String s = "UPDATE sys.Flight SET departLocation=?, arrivalLocation=?, departDate=?, arrivalDate=?, departTime=?, arrivalTime=?, capacity=?, openSeats=?, layover=? WHERE idFlight='" + FlightView.idFlightU.getText() + "'";
        	ps = con.prepareStatement(s);	
        	ps.setString(1, FlightView.departLocationU.getText());
			ps.setString(2, FlightView.arrivalLocationU.getText());
        	ps.setString(3, FlightView.departDateU.getEditor().getText());
        	ps.setString(4, FlightView.arrivalDateU.getEditor().getText());
			ps.setString(5, FlightView.departTimeU.getText());
			ps.setString(6, FlightView.arrivalTimeU.getText());
			ps.setString(7, FlightView.capacityU.getText());
			ps.setString(8, FlightView.openSeatsU.getText());
			ps.setString(9, FlightView.layoverU.getText());
			ps.executeUpdate();
			
			FlightView.table.getColumns().clear();
			FlightView.table.getItems().clear();
			FlightView.loadTable();
			
			FlightView.idFlightU.clear();
			FlightView.departLocationU.clear();
			FlightView.arrivalLocationU.clear();
			FlightView.departTimeU.clear();
			FlightView.arrivalTimeU.clear();
			FlightView.capacityU.clear();
			FlightView.openSeatsU.clear();
			FlightView.layoverU.clear();
			
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //method to delete a flight
    public static void deleteFlight() {
    	try {
        	//Delete flight info in table
        	String s = "DELETE FROM sys.Flight WHERE idFlight=?";
        	ps = con.prepareStatement(s);
        	ps.setString(1, FlightView.idFlightD.getText());
        	
			ps.executeUpdate();
        	
        	FlightView.table.getColumns().clear();
			FlightView.table.getItems().clear();
			FlightView.loadTable();
			
			FlightView.idFlightD.clear();
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
