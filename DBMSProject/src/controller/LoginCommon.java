package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Health_Supporter;
import models.Patient;
import models.Users;
import orm.BaseModel;

public class LoginCommon extends HttpServlet {

	public String email;
	public String password;
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		setEmail(req.getParameter("email"));
		setPassword(req.getParameter("password"));
		
		String where = "email ='" + getEmail() + "' and password = '" + getPassword()+"'";
		ArrayList<Object> userList = BaseModel.select(Users.class, where);
		RequestDispatcher requestDispatcher;
		
		if(userList.size()>0){
			HttpSession session = req.getSession();
			session.setAttribute("user_id", ((Users)userList.get(0)).id);
			req.getSession().setAttribute("as_hs", false);
			
			String where2 = "user_id = " + String.valueOf(((Users)userList.get(0)).getId());
			ArrayList<Object> supporters = Health_Supporter.select(Health_Supporter.class, where2);
			if(supporters!= null && supporters.size()>0){
				req.setAttribute("is_hs", true);
//				req.getSession().setAttribute("is_hs", true);
			}
			else{
				req.setAttribute("is_hs", false);
//				req.getSession().setAttribute("is_hs", false);
			}
			
			ArrayList<Object> patients = Patient.select(Patient.class, where2);
			if(patients.size()>0){
				req.setAttribute("is_patient", true);
				req.getSession().setAttribute("patient_id",req.getSession().getAttribute("user_id"));
				session.setAttribute("patient_password",req.getParameter("password"));

			}
			else{
				req.setAttribute("is_patient", false);
			}
		
			requestDispatcher=req.getRequestDispatcher("/home_common.jsp");
			requestDispatcher.forward(req,res);
		} else {
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
