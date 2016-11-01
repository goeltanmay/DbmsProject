package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Alert;

public class RemoveAlert extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		long alert_id = Long.parseLong(req.getParameter("id"));
		String where = "id = "+ alert_id;
		ArrayList<Object> b = Alert.select(Alert.class, where);
		Alert c = (Alert) b.get(0);
		c.cleared = 1;
		
		try {
			c.save();
		} catch (NullPointerException | SQLException | IllegalArgumentException | IllegalAccessException e) {
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
