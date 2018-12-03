package Data;

import java.sql.*;

public class Database {
	public static Connection ConnectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","Annie5992");
			System.out.println("Database connection success!");
			return con;
		} catch (Exception e) {
			System.out.println("Database connection issue!");
			return null;
		}
	}
	
	
    
}
