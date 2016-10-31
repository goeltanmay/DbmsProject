package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Ordinal_Observation_Type;
import models.Ordinal_Observation_Values;
import models.Patient;

public class AddOrdinalRecordValues extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		long patient_id = (long) req.getSession().getAttribute("patient_id");
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		
//		String where2 = "id = " + req.getParameter("observation");
//		ArrayList<Object> ordinal_list = Ordinal_Observation_Type.select(Ordinal_Observation_Type.class, where2);
//		Ordinal_Observation_Type oo = (Ordinal_Observation_Type) ordinal_list.get(0);
		String where3 = "oid = " + req.getParameter("observation");
		ArrayList<Object> ordinal_values_list = Ordinal_Observation_Values.select(Ordinal_Observation_Values.class, where3);
		req.setAttribute("values", ordinal_values_list);
		req.setAttribute("observation_type",req.getParameter("observation"));
		try {
			req.getRequestDispatcher("add_ordinal_record_values.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
