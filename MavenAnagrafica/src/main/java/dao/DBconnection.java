package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    

	
	public static Connection createConnection() throws SQLException {
		
		String driver = "com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/appazienda";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection(url, "root", "1234");
		
		return con;
	}
	
	
	
}
