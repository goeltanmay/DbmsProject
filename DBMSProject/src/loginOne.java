import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.User;

import models.Users;


public class loginOne implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException 	{
	
	String e=req.getParameter("email");
	String p=req.getParameter("password");

	Users newUser = new Users();
	newUser.name = "Testing";
	newUser.email = e;
	newUser.password = p;
	try {
		newUser.save();
		ArrayList<Users> arrayList = new ArrayList<Users>();
		for (Object f : newUser.select()){
			arrayList.add((Users) f);
		}
		
		for(Users u:arrayList)
		{
			System.out.println("The object is:");
			System.out.println(u.email);
			System.out.println(u.name);
			System.out.println(u.password);
		}
		
	} catch (NullPointerException | SQLException | IllegalArgumentException | IllegalAccessException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
//
//
//    String jdbcURL 
//	= "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
//
//            try {
//
//            // Load the driver. This creates an instance of the driver
//	    // and calls the registerDriver method to make Oracle Thin
//	    // driver available to clients.
//
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//	    String user = "apandey6";	// For example, "jsmith"
//	    String passwd = "200151827";	// Your 9 digit student ID number
//
//
//            Connection conn = null;
//            Statement stmt = null;
//            ResultSet rs = null;
//
//            try {
//
//		// Get a connection from the first driver in the
//		// DriverManager list that recognizes the URL jdbcURL
//
//		conn = DriverManager.getConnection(jdbcURL, user, passwd);
//
//		// Create a statement object that will be sending your
//		// SQL statements to the DBMS
//
//		stmt = conn.createStatement();
//
//		// Create the COFFEES table
//
//		rs = stmt.executeQuery("SELECT * from users where email='" + e + "' and password='" + p + "'");
//
//		// Now rs contains the rows of coffees and prices from
//		// the COFFEES table. To access the data, use the method
//		// NEXT to access all rows in rs, one row at a time
//        boolean flag=false;
//		while (rs.next()) 
//		{
//          if(rs.getString(3).equals(e)&& rs.getString(4).equals(p))
//          {
//             flag=true;
//             break;
//          }
//		}
//         if(flag)
//         {
//        	 System.out.println("You are a valid user");
//         }
//         else
//         {
//        	 System.out.println("You are not a valid user");         }
//            } finally {
//                close(rs);
//                close(stmt);
//                close(conn);
//            }
//        } catch(Throwable oops) {
//            oops.printStackTrace();
//        }
    }

    static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(Statement st) {
        if(st != null) {
            try { st.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch(Throwable whatever) {}
        }
    }


}
