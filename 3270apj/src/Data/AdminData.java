package Data;

import Application.Admin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;

public class AdminData {
	static ObservableList<Admin> admins; 
	static Connection con;
	static ResultSet rs;
	static Statement statement;
	static PreparedStatement ps;

	public static ObservableList<Admin> getAdmin() {
		
		//show admin data
		admins = FXCollections.observableArrayList();
		con = Database.ConnectDB();
		try {
			String s = "SELECT * FROM sys.Admin";
			statement = con.createStatement();
			rs = statement.executeQuery(s);
            if(rs != null) {
                while (rs.next()) {
                	Admin admin = new Admin();
                	admin.setIdAdmin(rs.getInt(1));
                	admin.setFirstName(rs.getString(2));
                	admin.setLastName(rs.getString(3));
                	admin.setUserName(rs.getString(4));
                	admin.setPassword(rs.getString(5));
                	
                	admins.add(admin);
                }
            }
		} catch(Exception e) {
			e.printStackTrace();
		}
		return admins;
	}
}
