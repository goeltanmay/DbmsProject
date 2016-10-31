package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Record_NOM_OBS_Type;
import orm.BaseModel;

public class ViewRecords extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		
		long pid=(long) req.getSession().getAttribute("patient_id");
		
		String where="pid="+pid;
		
		ArrayList<Object> recordList=BaseModel.select(Record_NOM_OBS_Type, where);
		
	}

}
