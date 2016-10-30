package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Health_Supporter;
import models.Patient;

public class ListHealthSupporters extends HttpServlet{
	
	public void doPost(HttpServletRequest  req, HttpServletResponse  resp){
		long patient_id = (long) req.getSession().getAttribute("patient_id");
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		ArrayList<Health_Supporter> hss = p.getHealthSupporters();
		req.setAttribute("health_supporters", hss);
		ArrayList<Object> all_hs = Health_Supporter.select(Health_Supporter.class,"");
		req.setAttribute("all_hs", all_hs);
		try {
			req.getRequestDispatcher("/patient_hss.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest  req, HttpServletResponse  resp){
		long patient_id = (long) req.getSession().getAttribute("patient_id");
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		ArrayList<Health_Supporter> hss = p.getHealthSupporters();
		req.setAttribute("health_supporters", hss);
		ArrayList<Object> all_hs = Health_Supporter.select(Health_Supporter.class,"");
		req.setAttribute("all_hs", all_hs);
		try {
			req.getRequestDispatcher("/patient_hss.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
