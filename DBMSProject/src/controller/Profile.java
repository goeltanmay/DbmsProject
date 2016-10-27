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

import models.Patient;
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

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
	{
			long pid=(long) req.getSession().getAttribute("user_id");
			String category="well";
			String where = "id=" + pid;
			String wherePatient = "user_id=" + pid;
			
			
			//System.out.println("Email is:"+email);
			
			ResultSet rs=null;
			
			try 
			{
				
				ArrayList<Object> userList = BaseModel.select(Users.class, where);
				
				for(Object o:userList)
				{
				 Users u=(Users)o;
				 req.setAttribute("name",u.name);
				 req.setAttribute("email",u.email);
				}
				
				rs= BaseModel.selectRaw("select PID from Diagnosis where pid=(select id from patient where "+where+")");
				while(rs.next())
				{
					category="sick";
				}
				
				
				
				ArrayList<Object> patientList = BaseModel.select(Patient.class, wherePatient);
				
				for(Object o:patientList)
				{
				 Patient p=(Patient)o;
				 req.setAttribute("dob",p.dob);
				 req.setAttribute("address",p.address);
				 req.setAttribute("gender",p.gender);
				 req.setAttribute("patientCategory",category);
				}
				
				 req.getRequestDispatcher("profile.jsp").forward(req, res);
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				//req.getRequestDispatcher("").forward(req,res);
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
