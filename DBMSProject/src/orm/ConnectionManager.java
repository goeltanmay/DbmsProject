package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static Connection conn = null;
	public static void init() throws ClassNotFoundException, SQLException{
		 String jdbcURL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 String user = "apandey6";	// For example, "jsmith"
		 String passwd = "200151827";	// Your 9 digit student ID number
		 conn = DriverManager.getConnection(jdbcURL, user, passwd);
		 return;
	}
	
	public static Connection getDbConnection() throws NullPointerException{
		if(conn != null)
			return conn;
		else throw new NullPointerException("DB connection is Null");
	}
	
	public static void closeConnection() throws SQLException{
		conn.close();
		return;
	}

}
