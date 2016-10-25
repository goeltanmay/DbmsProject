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


public class ProfileUpdate extends HttpServlet {
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

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		long pid=(long) req.getSession().getAttribute("patient_id");
		long uid=(long) req.getSession().getAttribute("user_id");
		String password=(String)req.getSession().getAttribute("patient_password");
		

		ResultSet rs=null;
		
		String category="well";
		String where = "id=" + pid;
		String wherePatient = "user_id=" + pid;
		
		Users user=new Users();
		user.id=pid;
		user.email=req.getParameter("email");
		user.name=req.getParameter("name");
		user.password=password;
		
		try {
			user.save();
		} catch (NullPointerException | IllegalArgumentException
				| IllegalAccessException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
//		Patient patient=new Patient();
		
		ArrayList<Object> pList=BaseModel.select(Patient.class, wherePatient);
		
		Patient patient = (Patient)pList.get(0);
//		patient.user_id = user;
		patient.address=req.getParameter("address");
		patient.gender=req.getParameter("gender");
		patient.dob=req.getParameter("dob");
		patient.user_id = user;
		
		try {
			patient.save();
		} catch (NullPointerException | IllegalArgumentException
				| IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
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
