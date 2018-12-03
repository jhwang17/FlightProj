package Application;

public class Admin {
	int idAdmin;
	String firstName;
	String lastName;
	String email;
	
	public Admin() {
		
	}
	public Admin(int idAdmin, String firstName, String lastName, String email) {
		this.idAdmin = idAdmin;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + idAdmin +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", password='" + email + '\'' +
                '}';
    }
}
