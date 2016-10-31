package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Observation_Type;
import models.Ordinal_Observation_Type;
import models.Ordinal_Observation_Values;
import models.Patient;

public class CreateOrdinalObservation extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		long patient_id = (long) req.getSession().getAttribute("patient_id");
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		
		String obs_id = req.getParameter("observation");
		String where2 = "id =" + obs_id;
		list = Observation_Type.select(Observation_Type.class, where2);
		Observation_Type obs = (Observation_Type) list.get(0);
		
		Ordinal_Observation_Type ob = new Ordinal_Observation_Type();
		ob.pid = p;
		ob.oid = obs;
		ob.frequency = Integer.parseInt(req.getParameter("freq"));
		ob.expected = req.getParameter("expected");
		try {
			ob.save();
		} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String values = req.getParameter("values");
		for(String value : values.split(",")){
			Ordinal_Observation_Values val = new Ordinal_Observation_Values();
			val.oid = ob;
			val.value = value.trim();
			try {
				val.save();
			} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			req.getRequestDispatcher("list_health_indicators").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
