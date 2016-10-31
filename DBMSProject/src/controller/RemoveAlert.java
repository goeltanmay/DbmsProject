package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Alert;

public class RemoveAlert extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		long alert_id = Long.parseLong(req.getParameter("id"));
		Alert a = new Alert();
		a.id = alert_id;
		try {
			a.delete();
		} catch (NullPointerException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			req.getRequestDispatcher("alerts").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
