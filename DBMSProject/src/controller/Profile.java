package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Users;
import orm.BaseModel;


public class Profile extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String email;
	public String password;
	public String gender;
	public String address;
	public String dob;
	public String patientCategory;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
	{
			String email=(String) req.getSession().getAttribute("email");
			String category="well";
			String where = "email ='" + email +"'";
			
			System.out.println("Email is:"+email);
			
			//System.out.println("Email is:"+email);
			
			ResultSet rs=null;
			
			try 
			{
				rs= BaseModel.selectRaw("select PID from Diagnosis where pid=(select id from users where "+where+")");
				while(rs.next())
				{
					category="sick";
				}
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			ArrayList<Object> userList = BaseModel.select(Users.class, where);
			RequestDispatcher requestDispatcher;
			
			for(Object u:userList)
			{
			 Users user=(Users)u;
			 req.setAttribute("name",user.name);
			 req.setAttribute("email",user.email);
			 req.setAttribute("patientCategory",category);
			 req.getRequestDispatcher("profile.jsp").forward(req, res);
			}
    }

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getPatientCategory() {
		return patientCategory;
	}

	public void setPatientCategory(String patientCategory) {
		this.patientCategory = patientCategory;
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
