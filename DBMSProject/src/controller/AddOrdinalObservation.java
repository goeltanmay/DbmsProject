package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Observation_Type;
import models.Patient;

public class AddOrdinalObservation extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		
		long patient_id = (long) req.getSession().getAttribute("patient_id");
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		
		ArrayList<Object> observations = Observation_Type.select(Observation_Type.class, "");
		req.setAttribute("observations", observations);
		try {
			req.getRequestDispatcher("add_ordinal_observation.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
