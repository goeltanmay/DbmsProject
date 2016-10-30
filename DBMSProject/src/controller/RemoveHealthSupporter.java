package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Health_Supporter;
import models.Patient;

public class RemoveHealthSupporter extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		long patient_id = (long) req.getSession().getAttribute("patient_id");
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		long hs_id = Long.parseLong(req.getParameter("hs"));
		where = "id = " + hs_id;
		ArrayList<Object> hss_list = Health_Supporter.select(Health_Supporter.class, where);
		Health_Supporter hs = (Health_Supporter) hss_list.get(0);
		p.remove_hs(hs);
		try {
			req.getRequestDispatcher("/list_of_health_supporters").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
