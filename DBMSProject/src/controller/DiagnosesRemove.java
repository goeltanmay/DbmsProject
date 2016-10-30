package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Diagnosis;
import models.Health_Supporter;
import models.Patient;
import models.Sick_Patient;
import orm.BaseModel;


public class DiagnosesRemove extends HttpServlet {
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
		String[] removeDiag = req.getParameterValues("removeDiag");
		
		long pid=(long)req.getSession().getAttribute("patient_id");
		long did=0;
		ResultSet rs=null;
		
		Boolean flag=false;
		
		for(int i=0;i<removeDiag.length;i++)
		{
		  try {
			rs=BaseModel.selectRaw("select id from disease_type where disease_name='"+removeDiag[i]+"'");
			while(rs.next())
			{
				  did=rs.getLong(1);
			}
			rs=BaseModel.selectRaw("select id from diagnosis where pid="+pid+" and did="+did);
			Diagnosis diagnosis=new Diagnosis();
			while(rs.next())
			{
				diagnosis.id=rs.getLong(1);
			}
			flag=diagnosis.delete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace()
			;
		}
		  
		}
		
		String where="pid="+pid;
		
		// If all diagnosis have been removed. change this patient to well.
		ArrayList<Object> diagnosisList=BaseModel.select(Diagnosis.class, where);
		
		if(diagnosisList.isEmpty())
		{
			Patient p=new Patient();
			p.id=pid;
		    p.changeToWell();
		
		}
		
		req.getRequestDispatcher("successDiagnosesUpdate.jsp").forward(req,res);;
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
