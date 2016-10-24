package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Users;


public class SignUp extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("we are in gooood handssssssssssss");
		
		Users user=new Users();
		
		user.name=req.getParameter("name");
		user.email=req.getParameter("email");
		user.password=req.getParameter("password");
//		user.gender=req.getParameter("gender");
//		user.address=req.getParameter("address");
//		user.dob=req.getParameter("dob");//2013-2-25
		
		RequestDispatcher rd;
		
		try {
			user.save();
			rd=req.getRequestDispatcher("successSignUp.jsp");
			rd.forward(req, res);
			
			
		} catch (NullPointerException | IllegalArgumentException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd=req.getRequestDispatcher("signUpError.jsp");
			rd.forward(req, res);
		}
		
	
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

}
