package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Health_Supporter;
import models.Patient;

public class UpdateHealthSupporter extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		long patient_id = (long) req.getSession().getAttribute("patient_id");
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		ArrayList<Health_Supporter> hss = p.getHealthSupporters();
		String role = req.getParameter("hs_role");
		long hs_id = Long.parseLong(req.getParameter("hs"));
		where = "id = " + hs_id;
		ArrayList<Object> hss_list = Health_Supporter.select(Health_Supporter.class, where);
		Health_Supporter hs = (Health_Supporter) hss_list.get(0);
		String authDate=req.getParameter("date");
		try {
			p.setHealthSupporter(role, hs,authDate);
		} catch (NullPointerException | IllegalArgumentException
				| IllegalAccessException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			req.getRequestDispatcher("/list_of_health_supporters").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
