package Application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
	
	SimpleIntegerProperty idCustomer;
	SimpleStringProperty firstName;
	SimpleStringProperty lastName;
	SimpleStringProperty street;
	SimpleStringProperty city;
	SimpleStringProperty state;
	SimpleStringProperty zipCode;
	SimpleStringProperty email;
	SimpleStringProperty ssn;
	SimpleStringProperty userName;
	SimpleStringProperty password;
	SimpleStringProperty securityQuestion;
	SimpleStringProperty securityAnswer;
		
	public Customer() {
		
	}
	
	public Customer(Integer id, String fName, String lName, String streetS, 
					String stateS, String cityS, String zip, String emailS, 
					String ssN, String userN, String passW, String sQuestion,
					String sAnswer) {
		
		idCustomer = new SimpleIntegerProperty(id);
		firstName = new SimpleStringProperty(fName);
		lastName = new SimpleStringProperty(lName);
		street = new SimpleStringProperty(streetS);
		state = new SimpleStringProperty(stateS);
		city = new SimpleStringProperty(cityS);
		zipCode = new SimpleStringProperty(zip);
		email = new SimpleStringProperty(emailS);
		ssn = new SimpleStringProperty(ssN);
		userName = new SimpleStringProperty(userN);
		password = new SimpleStringProperty(passW);
		securityQuestion = new SimpleStringProperty(sQuestion);
		securityAnswer = new SimpleStringProperty(sAnswer);
	}
	
	// Getter and Setters for variables
	public int getIdCustomer() {
		return idCustomer.get();
		
	}
	
	public void setIdCustomer(Integer id) {
		idCustomer = new SimpleIntegerProperty(id); //can't use .set, need to cast it to new SimpleIntegeryProperty
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
	
	public String getStreet() {
		return street.get();
	}
	
	public void setStreet(String streetS) {
		street = new SimpleStringProperty(streetS);
	}
	
	public String getCity() {
		return city.get();
	}
	
	public void setCity(String cityS) {
		city = new SimpleStringProperty(cityS);
	}
	
	public String getState() {
		return state.get();
	}
	
	public void setState(String stateS) {
		state = new SimpleStringProperty(stateS);
	}
	
	public String getZipCode() {
		return zipCode.get();
	}
	
	public void setZipCode(String zip) {
		zipCode = new SimpleStringProperty(zip);
	}
	
	public String getEmail() {
		return email.get();
	}
	
	public void setEmail(String emailS) {
		email = new SimpleStringProperty(emailS);
	}
	
	public String getSsn() {
		return ssn.get();
	}
	
	public void setSsn(String ssN) {
		ssn = new SimpleStringProperty(ssN);
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
	
	public String getSecurityQuestion() {
		return securityQuestion.get();
	}
	
	public void setSecurityQuestion(String sQuestion) {
		securityQuestion = new SimpleStringProperty(sQuestion);
	}
	
	public String getSecurityAnswer() {
		return securityAnswer.get();
	}
	
	public void setSecurityAnswer(String sAnswer) {
		securityAnswer = new SimpleStringProperty(sAnswer);
	}
		
	@Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", street=" + street +
                ", state=" + state +
                ", city" + city +
                ", zipCode" + zipCode +
                ", email" + email +
                ", ssn" + ssn +
                ", userName" + userName + 
                ", password" + password +
                ", securityQuestion" + securityQuestion +
                ", securityAnswer" + securityAnswer +  
                '}';
    }
}
