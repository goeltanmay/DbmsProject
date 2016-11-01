package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orm.BaseModel;
import models.Health_Supporter;
import models.Patient;
import models.Sick_Patient;
import models.Users;
import models.Well_Patient;

public class ListHSPatients extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
	long user_id = (long) req.getSession().getAttribute("user_id");
	ArrayList<Object> hsList = Health_Supporter.select(Health_Supporter.class, "user_id = " + user_id);
	Health_Supporter hs = (Health_Supporter) hsList.get(0);
	
	ArrayList<Patient> patientList=new ArrayList<Patient>();
	req.getSession().setAttribute("as_hs", true);
	
	String where="hsid1="+user_id+" or hsid2="+user_id;
	
	// get the well-patient list
	ArrayList<Object> wellList = BaseModel.select(Well_Patient.class,where);
	for(Object obj:wellList) {
		patientList.add(((Well_Patient)obj).pid);
	}
	
	
	// get the sick list.
	ArrayList<Object> sickList = BaseModel.select(Sick_Patient.class,where);
	for(Object obj:sickList) {
		patientList.add(((Sick_Patient)obj).pid);
	}
	
	req.setAttribute("patients",patientList);
	req.getRequestDispatcher("PatientInfo.jsp").forward(req, resp);;
	
	}
	
	
}
