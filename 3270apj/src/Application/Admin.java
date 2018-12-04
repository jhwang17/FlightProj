package Application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Admin {
	
	SimpleIntegerProperty idAdmin;
	SimpleStringProperty firstName;
	SimpleStringProperty lastName;
	SimpleStringProperty userName;
	SimpleStringProperty password;
	
	public Admin() {
		
	}
	
	public Admin(Integer id, String fName, String lName, String userN, String passW) {
		idAdmin = new SimpleIntegerProperty(id);
		firstName = new SimpleStringProperty(fName);
		lastName = new SimpleStringProperty(lName);
		userName = new SimpleStringProperty(userN);
		password = new SimpleStringProperty(passW);
	}

	// Getters and Setters for variables 
	public int getIdAdmin() {
		return idAdmin.get();
		
	}
	
	public void setIdAdmin(Integer id) {
		idAdmin = new SimpleIntegerProperty(id); //can't use .set, need to cast it to new SimpleIntegeryProperty
	}
	
	public String getFirstName() {
		return firstName.get();
	}
	
	public void setFirstName(String fName) {
		firstName = new SimpleStringProperty(fName);
	}
	
	public String getLastName() {
		return lastName.get();
	}
	
	public void setLastName(String lName) {
		lastName = new SimpleStringProperty(lName);
	}
	
	public String getUserName() {
		return userName.get();
	}
	
	public void setUserName(String userN) {
		userName = new SimpleStringProperty(userN);
	}
	
	public String getPassword() {
		return password.get();
	}
	
	public void setPassword(String passW) {
		password = new SimpleStringProperty(passW);
	}
	
	@Override
    public String toString() {
        return "Admin{" +
                "idAdmin=" + idAdmin +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", userName" + userName + 
                ", password" + password +  
                '}';
    }
}
