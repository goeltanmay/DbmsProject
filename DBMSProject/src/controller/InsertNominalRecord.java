package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Observation_Type;
import models.Patient;
import models.Record_NOM_OBS_Type;
import models.Users;

public class InsertNominalRecord extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Record_NOM_OBS_Type nomRecord=new Record_NOM_OBS_Type();
		
		Users uid=(Users)req.getSession().getAttribute("user_id");
		Patient pid=(Patient)req.getSession().getAttribute("patient_id");

		nomRecord.userid=uid;
		nomRecord.pid=pid;
		
		Observation_Type ot=new Observation_Type();
		ot.id=Long.parseLong(req.getParameter("observation"));
		
		nomRecord.oid=ot;
		
		
		
		
		
	}
	
}
