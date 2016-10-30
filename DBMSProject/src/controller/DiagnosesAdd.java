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
import javax.servlet.http.HttpSession;

import orm.BaseModel;
import models.Diagnosis;
import models.Disease_Type;
import models.Health_Supporter;
import models.Patient;
import models.Users;


public class DiagnosesAdd extends HttpServlet {
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
			throws ServletException, IOException 
	{
		
		long pid=(long)req.getSession().getAttribute("patient_id");
		
		String where = "id = " + pid;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		if (!p.isSick()) {
			ArrayList<Health_Supporter> hss = p.getHealthSupporters();
			if(hss.get(0) != null){
				p.changeToSick();
			}
			else{
				// redirect to add hss
				req.getRequestDispatcher("list_of_health_supporters").forward(req, res);
				return;
			}
		}	
		String[] addDiag = req.getParameterValues("addDiag");
		String diagDate = req.getParameter("date");
		ResultSet rs=null;
		where=null;
		
		for(int i=0;i<addDiag.length;i++)
		{
		 Diagnosis diagnosis=new Diagnosis();
		 Patient pat = new Patient();
		 pat.id = pid;
		 diagnosis.pid=pat;
		 diagnosis.Diagnosis_Date=diagDate;
		 
		 where="disease_name='"+addDiag[i]+"'";
		 
		 System.out.println("where is:"+where);
		 
		 ArrayList<Object> DiseaseList=BaseModel.select(Disease_Type.class,where);
		 
		 if(DiseaseList.size()>0) {
				diagnosis.did=(Disease_Type)DiseaseList.get(0);
		 }
	
		 try {
			diagnosis.save();
		} catch (NullPointerException | IllegalArgumentException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
		
		req.getRequestDispatcher("successDiagnosesUpdate.jsp").forward(req, res);;
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
