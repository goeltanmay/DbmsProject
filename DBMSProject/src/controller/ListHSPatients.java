package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Health_Supporter;
import models.Users;

public class ListHSPatients extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
	long user_id = (long) req.getAttribute("user_id");
	ArrayList<Object> hsList = Health_Supporter.select(Health_Supporter.class, "user_id = " + user_id);
	Health_Supporter hs = (Health_Supporter) hsList.get(0);
	hs.user_id = new Users();
	hs.user_id.id = user_id;
	// get the patient list
	// render the patient list.
	// once this list is rendered, use the patient_id attribute to display the patient dashboard.
	
	}
	
	
}
