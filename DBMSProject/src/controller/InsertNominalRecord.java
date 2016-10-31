package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orm.BaseModel;
import models.Observation_Type;
import models.Patient;
import models.Records_NOM_OBS_Type;
import models.Users;

public class InsertNominalRecord extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Records_NOM_OBS_Type nomRecord=new Records_NOM_OBS_Type();

		Records_NOM_OBS_Type nomRecordDisplay=new Records_NOM_OBS_Type();
		String whered=""; 
		
		ArrayList<Object> dispList=BaseModel.select(Records_NOM_OBS_Type.class,whered);
		
		Users user=new Users();
		user.id=(long)req.getSession().getAttribute("user_id");
		Users uid=user;

		Patient p=new Patient();
		p.id=(long)req.getSession().getAttribute("patient_id");
		

		nomRecord.userid=uid;
		nomRecord.pid=p;
		
		Observation_Type ot=new Observation_Type();
		ot.id=Long.parseLong(req.getParameter("observation"));
		
		nomRecord.noid=ot;
		
		nomRecord.readings=Integer.parseInt(req.getParameter("reading"));
		nomRecord.observation_timestamp=(String)req.getParameter("obtime");
		nomRecord.recording_timestamp="";
		
		try {
			nomRecord.save();
			req.getRequestDispatcher("successRecordsUpdate.jsp").forward(req, resp);
		} catch (NullPointerException | IllegalArgumentException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
}
