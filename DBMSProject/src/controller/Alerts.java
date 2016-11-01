package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orm.BaseModel;
import models.Alert;

public class Alerts extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Alert> alertList=new ArrayList<Alert>();
		
		long pid=Long.parseLong(req.getSession().getAttribute("patient_id"));
		boolean as_hs = (boolean) req.getSession().getAttribute("as_hs");
		
		req.setAttribute("as_hs", as_hs);
		
		String where="pid = "+pid+" and cleared=0";
		
		ArrayList<Object> obj=Alert.select(Alert.class, where);
		
		for(Object object:obj){
			if(object != null)
				alertList.add((Alert)object);
		}
		
		req.setAttribute("alertList",alertList);
		
		req.getRequestDispatcher("Alerts.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Alert> alertList=new ArrayList<Alert>();
		
		long pid=(long)req.getSession().getAttribute("patient_id");
		boolean as_hs = (boolean) req.getSession().getAttribute("as_hs");
		
		req.setAttribute("as_hs", as_hs);
		
		String where="pid="+pid+"and cleared=0";
		
		ArrayList<Object> obj=Alert.select(Alert.class, where);
		
		for(Object object:obj){
			if(object != null)
				alertList.add((Alert)object);
		}
		
		req.setAttribute("alertList",alertList);
		
		req.getRequestDispatcher("Alerts.jsp").forward(req, resp);
		
	}

}
