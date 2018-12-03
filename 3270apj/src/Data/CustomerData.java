package Data;

import Application.Customer;
import Reservation.CustomerView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class CustomerData {
	static ObservableList<Customer> customers; 
	static Connection con;
	static ResultSet rs;
	static Statement statement;
	static PreparedStatement ps;

	public static ObservableList<Customer> getCustomer() {
		
		//show customer data
		customers = FXCollections.observableArrayList();
		con = Database.ConnectDB();
		try {
			String s = "SELECT * FROM sys.Customer";
			statement = con.createStatement();
			rs = statement.executeQuery(s);
            if(rs != null) {
                while (rs.next()) {
                	Customer customer = new Customer();
                	customer.setIdCustomer(rs.getInt(1));
                	customer.setFirstName(rs.getString(2));
                	customer.setLastName(rs.getString(3));
                	customer.setStreet(rs.getString(4));
                	customer.setCity(rs.getString(5));
                	customer.setState(rs.getString(6));
                	customer.setZipCode(rs.getString(7));
                	customer.setEmail(rs.getString(8));
                	customer.setSsn(rs.getString(9));
                	customer.setUserName(rs.getString(10));
                	customer.setPassword(rs.getString(11));
                	customer.setSecurityQuestion(rs.getString(12));
                	customer.setSecurityAnswer(rs.getString(13));
                	
                	customers.add(customer);
                }
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return customers;
	}
	
	//method to add a customer
    public static void insertCustomer() {
        try {
        	if (CustomerView.firstNameA.getText().isEmpty() ||
        		CustomerView.lastNameA.getText().isEmpty() ||
        		CustomerView.emailA.getText().isEmpty() ||
        		CustomerView.ssnA.getText().isEmpty() ||
        		CustomerView.userNameA.getText().isEmpty() ||
        		CustomerView.passwordA.getText().isEmpty() ||
        		CustomerView.securityQuestionA.getText().isEmpty() ||
        		CustomerView.securityAnswerA.getText().isEmpty()) {
        		
        		return; //stops the insert
        	}
        	
        	//Add customer to table
        	String s = "INSERT INTO sys.Customer (idCustomer, firstName, lastName, streetAddress, city, state, zipCode, email, ssn, userName, password, securityQuestion, securityAnswer) VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(s);
			ps.setString(1, CustomerView.firstNameA.getText());
			ps.setString(2, CustomerView.lastNameA.getText());
			ps.setString(3, CustomerView.streetA.getText());
			ps.setString(4, CustomerView.cityA.getText());
			ps.setString(5, CustomerView.stateA.getText());
			ps.setString(6, CustomerView.zipCodeA.getText());
			ps.setString(7, CustomerView.emailA.getText());
			ps.setString(8, CustomerView.ssnA.getText());
			ps.setString(9, CustomerView.userNameA.getText());
			ps.setString(10, CustomerView.passwordA.getText());
			ps.setString(11, CustomerView.securityQuestionA.getText());
			ps.setString(12, CustomerView.securityAnswerA.getText());
			ps.executeUpdate();
			
			CustomerView.table.getColumns().clear();
			CustomerView.table.getItems().clear();
			CustomerView.loadTable();
			
			//clear the text in hbox after adding
			CustomerView.firstNameA.clear();
			CustomerView.lastNameA.clear();
			CustomerView.streetA.clear();
			CustomerView.cityA.clear();
			CustomerView.stateA.clear();
			CustomerView.zipCodeA.clear();
			CustomerView.emailA.clear();
			CustomerView.ssnA.clear();
			CustomerView.userNameA.clear();
			CustomerView.passwordA.clear();
			CustomerView.securityQuestionA.clear();
			CustomerView.securityAnswerA.clear();
			
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
  //method to update a customer
    public static void updateCustomer() {
        try{
        	//Update customer info to table
        	String s = "UPDATE sys.Customer SET firstName=?, lastName=?, streetAddress=?, city=?, state=?, zipCode=?, email=?, ssn=?, userName=?, password=?, securityQuestion=?, securityAnswer=? WHERE idCustomer='" + CustomerView.idCustomerU.getText() + "'";
        	ps = con.prepareStatement(s);	
        	ps.setString(1, CustomerView.firstNameU.getText());
        	ps.setString(2, CustomerView.lastNameU.getText());
			ps.setString(3, CustomerView.streetU.getText());
			ps.setString(4, CustomerView.cityU.getText());
			ps.setString(5, CustomerView.stateU.getText());
			ps.setString(6, CustomerView.zipCodeU.getText());
			ps.setString(7, CustomerView.emailU.getText());
			ps.setString(8, CustomerView.ssnU.getText());
			ps.setString(9, CustomerView.userNameU.getText());
			ps.setString(10, CustomerView.passwordU.getText());
			ps.setString(11, CustomerView.securityQuestionU.getText());
			ps.setString(12, CustomerView.securityAnswerU.getText());
			ps.executeUpdate();
			
			CustomerView.table.getColumns().clear();
			CustomerView.table.getItems().clear();
			CustomerView.loadTable();
			
			//clear the text in hbox after updating
			CustomerView.idCustomerU.clear();
			CustomerView.firstNameU.clear();
			CustomerView.lastNameU.clear();
			CustomerView.streetU.clear();
			CustomerView.cityU.clear();
			CustomerView.stateU.clear();
			CustomerView.zipCodeU.clear();
			CustomerView.emailU.clear();
			CustomerView.ssnU.clear();
			CustomerView.userNameU.clear();
			CustomerView.passwordU.clear();
			CustomerView.securityQuestionU.clear();
			CustomerView.securityAnswerU.clear();
			
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //method to delete a customer
    public static void deleteCustomer(){
        try{
        	//Delete customer info in table
        	String s = "DELETE FROM sys.Customer WHERE idCustomer=? AND ssn=?";
        	ps = con.prepareStatement(s);
        	ps.setString(1, CustomerView.idCustomerD.getText());
        	ps.setString(2, CustomerView.ssnD.getText());
        	ps.executeUpdate();
        	
        	CustomerView.table.getColumns().clear();
			CustomerView.table.getItems().clear();
			CustomerView.loadTable();
			
			CustomerView.idCustomerD.clear();
			CustomerView.ssnD.clear();
			
			
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
