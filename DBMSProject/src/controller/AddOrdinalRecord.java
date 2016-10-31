package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Disease_Type;
import models.Nominal_Observation_Type;
import models.Observation_Type;
import models.Ordinal_Observation_Type;
import models.Patient;

public class AddOrdinalRecord extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
		long patient_id = (long) req.getSession().getAttribute("patient_id");
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
	
		ArrayList<Object> nominals = Observation_Type.getNominalObservationTypesForPatient(p);
		ArrayList<Object> ordinals = Observation_Type.getOrdinalObservationTypesForPatient(p);
		
		ArrayList<Disease_Type> diseases = p.getDiseases();
		for (Disease_Type d : diseases){
			ArrayList<Object> nominals_disease = Observation_Type.getNominalObservationTypeForDisease(d);
			for(Object n : nominals_disease){
				if(n != null){
					if(!nominals.contains((Nominal_Observation_Type)n)) nominals.add(n);
				}
			}
			
			ArrayList<Object> ordinals_disease = Observation_Type.getOrdinalObservationTypeForDisease(d);
			for(Object n : ordinals_disease){
				if(n != null){
					if(!ordinals.contains((Ordinal_Observation_Type)n)) ordinals.add(n);
				}
			}
		}
		
		ArrayList<Object> general_nominals = Observation_Type.getNominalObservationTypeForAll();
		for(Object o: general_nominals){
			if(o !=null){
				if(!nominals.contains((Nominal_Observation_Type)o)){
					nominals.add((Nominal_Observation_Type)o);
				}
			}
		}
		
		ArrayList<Object> general_ordinals = Observation_Type.getOrdinalObservationTypeForAll();
		for(Object o: general_ordinals){
			if(o !=null){
				if(!nominals.contains((Ordinal_Observation_Type)o)){
					nominals.add((Ordinal_Observation_Type)o);
				}
			}
		}
		
		req.setAttribute("nominals", nominals);
		req.setAttribute("ordinals", ordinals);
		
		try {
			req.getRequestDispatcher("add_ordinal_record.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
