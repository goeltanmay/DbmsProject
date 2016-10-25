package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Health_Supporter;
import models.Users;


public class HSSignup extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("we are in gooood handssssssssssss");
		
		RequestDispatcher rd;
		
		try {
			Health_Supporter hs = new Health_Supporter();
			hs.user_id = new Users();
			HttpSession session = req.getSession();
			hs.user_id.id = (long) session.getAttribute("user_id");
			hs.phone_number = req.getParameter("contact");
			hs.save();
			req.getRequestDispatcher("successSignUp.jsp").forward(req, res);
			
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
