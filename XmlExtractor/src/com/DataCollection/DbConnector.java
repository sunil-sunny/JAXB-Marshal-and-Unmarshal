

import java.sql.Connection;

/*
 * This class establishes connection with data base
 */
import java.sql.DriverManager;
public class DbConnector {
	
	public Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Loading the driver
		}
		catch(Exception e) {
			System.out.println("SQL Driver Error");
		}
		try {
			//getting the connection object after establishing connection with mysql data base
			con=DriverManager.getConnection("jdbc:mysql://db.cs.dal.ca:3306?serverTimezone=UTC","menta","B00832218");

		}
		catch(Exception e) {
			System.out.println("Error connecting the Data Base");
		}
		
		return con;

	}
	
}
