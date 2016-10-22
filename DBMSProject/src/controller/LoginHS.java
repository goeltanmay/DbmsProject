package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHS extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String email;
	public String password;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		setEmail(req.getParameter("emailHS"));
		setPassword(req.getParameter("passwordHS"));
		//String e=req.getParameter("email");
		//String p=req.getParameter("password");
		
		boolean success = true;//Call db to check if account already exists
		if (success) {
			res.sendRedirect("home.jsp");
		} else {
			res.sendRedirect("loginFailure.jsp");
		}
    }

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

}
