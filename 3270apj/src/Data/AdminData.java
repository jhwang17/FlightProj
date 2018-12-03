package Data;

import Application.Admin;
import java.sql.*;
import java.util.ArrayList;

public class AdminData {
	static ArrayList<Admin> admins;
	static Statement statement;
	
	public static ArrayList<Admin> getAdmin() {
		admins = new ArrayList<>();
		
		try {
			statement = Database.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT* FROM Admin");
            
            if (rs != null) {
            	while (rs.next()) {
            		Admin admin = new Admin();
                    admin.setIdAdmin(rs.getInt(1));
                    admin.setFirstName(rs.getString(2));
                    admin.setLastName(rs.getString(3));
                    admin.setEmail(rs.getString(4));
                    
                    admins.add(admin);
            	}
            }
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return admins;
		
	}
}
