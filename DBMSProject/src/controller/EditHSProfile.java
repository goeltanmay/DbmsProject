package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Health_Supporter;
import models.Users;

public class EditHSProfile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get the user id
		// get the user object and the health supporter object
		// set the details in the request obj
		long user_id = (long)req.getSession().getAttribute("user_id");
		String where1 = "id = " + user_id;
		String where2 = "user_id = " + user_id;
		ArrayList<Object> userList = Users.select(Users.class, where1);
		ArrayList<Object> hsList = Health_Supporter.select(Health_Supporter.class, where2);
		
		if(hsList !=null && hsList.size()>0) {
			Users user = (Users) userList.get(0);
			Health_Supporter hs = (Health_Supporter) hsList.get(0);
			req.setAttribute("user", user);
			req.setAttribute("hs", hs);
			req.getRequestDispatcher("HSProfile.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// get the user id
		// get the user object and the health supporter object
		// set the details in the request obj
		long user_id = (long)req.getSession().getAttribute("user_id");
		String where1 = "id = " + user_id;
		String where2 = "user_id = " + user_id;
		ArrayList<Object> userList = Users.select(Users.class, where1);
		ArrayList<Object> hsList = Health_Supporter.select(Health_Supporter.class, where2);
		
		if(hsList !=null && hsList.size()>0) {
			Users user = (Users) userList.get(0);
			Health_Supporter hs = (Health_Supporter) hsList.get(0);
			req.setAttribute("user", user);
			req.setAttribute("hs", hs);
			req.getRequestDispatcher("HSProfile.jsp").forward(req, resp);
		}
	}
}
