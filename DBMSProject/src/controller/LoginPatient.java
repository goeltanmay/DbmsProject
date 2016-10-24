package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Users;
import orm.BaseModel;


public class LoginPatient extends HttpServlet {
	public String email;
	public String password;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		setEmail(req.getParameter("emailPatient"));
		setPassword(req.getParameter("passwordPatient"));
		//String e=req.getParameter("email");
		//String p=req.getParameter("password");
        String where = "email ='" + getEmail() + "' and password = '" + getPassword()+"'";
		ArrayList<Object> userList = BaseModel.select(Users.class, where);
		RequestDispatcher requestDispatcher;
		if(userList.size() > 0){
			// user is logged in
			HttpSession session = req.getSession();
			session.setAttribute("user_id", ((Users)userList.get(0)).id);
			requestDispatcher=req.getRequestDispatcher("/home.jsp");
			requestDispatcher.forward(req,res);
		}
		else{
			// return to login page with error message.
			requestDispatcher=req.getRequestDispatcher("/loginFailure.jsp");
			requestDispatcher.forward(req,res); 
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
