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
import models.Records_ORD_OBS_Type;
import models.Users;

public class AddOrdinalRecordFinal extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		long patient_id = (long) req.getSession().getAttribute("patient_id");
		String where = "id = " + patient_id;
		ArrayList<Object> list = Patient.select(Patient.class, where);
		Patient p = (Patient) list.get(0);
		
		long user_id = (long) req.getSession().getAttribute("user_id");
		String whereuser = "id = " + user_id;
		ArrayList<Object> listuser = Users.select(Users.class, whereuser);
		Users u = (Users) listuser.get(0);
		
		Records_ORD_OBS_Type obs = new Records_ORD_OBS_Type();
		obs.observation_timestamp = req.getParameter("recording_time");
		obs.userid = u;
		long observation_id = Long.parseLong(req.getParameter("observation_type"));
		String where2 = "id = " + observation_id;
		ArrayList<Object> list2 = Ordinal_Observation_Type.select(Ordinal_Observation_Type.class, where2);
		Ordinal_Observation_Type oo = (Ordinal_Observation_Type) list2.get(0);
		obs.ooid = oo;
		obs.pid = p;
		obs.recording_timestamp="";
		String value_id = req.getParameter("observation");
		String where3 = "id = " + value_id;
		ArrayList<Object> ov = Ordinal_Observation_Values.select(Ordinal_Observation_Values.class, where3);
		Ordinal_Observation_Values v = (Ordinal_Observation_Values) ov.get(0);
		obs.readings = v;
		try {
			obs.save();
		} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			req.getRequestDispatcher("add_ordinal_record").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
