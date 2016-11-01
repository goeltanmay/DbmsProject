package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Nominal_Observation_Type;
import models.Observation_Type;
import models.Patient;

public class CreateNominalObservation extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		long patient_id = Long.parseLong((String)req.getSession().getAttribute("patient_id"));
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		
		String obs_id = req.getParameter("observation");
		String where2 = "id =" + obs_id;
		list = Observation_Type.select(Observation_Type.class, where2);
		Observation_Type obs = (Observation_Type) list.get(0);
		String where_nom = "pid = " + p.id + " and oid = "+ obs.id;
		ArrayList<Object> lists = Nominal_Observation_Type.select(Nominal_Observation_Type.class, where_nom);
		Nominal_Observation_Type nm;
		if(lists.size()>0){
			nm = (Nominal_Observation_Type) lists.get(0);
		}
		else 
			nm = new Nominal_Observation_Type();
		nm.pid = p;
		nm.oid = obs;
		nm.lower_limit = Integer.parseInt(req.getParameter("lower"));

		nm.upper_limit = Integer.parseInt(req.getParameter("upper"));

		nm.frequency = Integer.parseInt(req.getParameter("freq"));
		try {
			nm.save();
		} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			req.getRequestDispatcher("/list_health_indicators").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
