package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Application.Flight;
import Application.Reserve;
import Reservation.FlightView;
import Reservation.ReserveView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ReserveData {
	static ObservableList<Reserve> reserves; 
	static Connection con;
	static ResultSet rs;
	static Statement statement;
	static PreparedStatement ps;
	
	public static ObservableList<Reserve> getReserve() {
		//show reservation data
				reserves = FXCollections.observableArrayList();
				con = Database.ConnectDB();
				try {
					String s = "SELECT * FROM sys.Reservation";
					statement = con.createStatement();
					rs = statement.executeQuery(s);
		            if(rs != null) {
		                while (rs.next()) {
		                	Reserve reserve = new Reserve();
		                	reserve.setIdReservation(rs.getInt(1));
		                	reserve.setIdCustomer(rs.getInt(2));
		                	reserve.setIdFlight(rs.getInt(3));
		                	reserve.setIdSeat(rs.getInt(4));
		                	
		                	reserves.add(reserve);
		                }
		            }
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				return reserves;
			}
			
	//method to add a reservation
    public void insertReserve(int cusID, int flightID, int seatID) {
        try {
        	/*
        	if (ReserveView.idCustomerA.getEditor().getText().isEmpty() ||
        		ReserveView.idFlightA.getEditor().getText().isEmpty() ||
        		ReserveView.idSeatA.getText().isEmpty()) {
        		return; //stops the insert
        	}
        	
        	//Add reservation to table
        	String s = "INSERT INTO sys.Reservation (idReservation, idCustomer, idFlight, idSeat) VALUES (default,?,?,?)";
			ps = con.prepareStatement(s);
			ps.setString(1, ReserveView.idCustomerA.getText());
			ps.setString(2, ReserveView.idFlightA.getText());
			ps.setString(3, ReserveView.idSeatA.getText());
			
			ps.executeUpdate();
			
			ReserveView.table.getColumns().clear();
			ReserveView.table.getItems().clear();
			ReserveView.loadTable();
			
			ReserveView.idCustomerA.clear();
			ReserveView.idFlightA.clear();
			ReserveView.idSeatA.clear();
        	*/
        	
        	//Add reservation to table
        	String s = "INSERT INTO sys.Reservation (idReservation, idCustomer, idFlight, idSeat) VALUES (default,?,?,?)";
			ps = con.prepareStatement(s);
			ps.setString(1, String.valueOf(cusID));
			ps.setString(2, String.valueOf(flightID));
			ps.setString(3, String.valueOf(seatID));
			
			ps.executeUpdate();
			
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    /*
  //method to update a reservation
    public static void updateReserve() {
        try{
        	//Update reservation info to table        			
        	String s = "UPDATE sys.Reservation SET idCustomer=?, idFlight=?, idSeat=? WHERE idFlight='" + ReserveView.idReservationU.getText() + "'";
        	ps = con.prepareStatement(s);	
        	ps.setString(1, ReserveView.idCustomerU.getText());
        	ps.setString(2, ReserveView.idFlightU.getText());
			ps.setString(3, ReserveView.idSeatU.getText());
			ps.executeUpdate();
			
			ReserveView.table.getColumns().clear();
			ReserveView.table.getItems().clear();
			ReserveView.loadTable();
			
			ReserveView.idReservationU.clear();
			ReserveView.idCustomerU.clear();
			ReserveView.idFlightU.clear();
			ReserveView.idSeatU.clear();
						
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //method to delete a reservation
    public static void deleteReserve(){
        try{
        	//Delete reservation info in table
        	String s = "DELETE FROM sys.Reservation WHERE idReservation=?";
        	ps = con.prepareStatement(s);
        	ps.setString(1, ReserveView.idReseravtionD.getText());
        	
			ps.executeUpdate();
        	
			ReserveView.table.getColumns().clear();
			ReserveView.table.getItems().clear();
			ReserveView.loadTable();
			
			ReserveView.idReservationD.clear();
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    */
}
