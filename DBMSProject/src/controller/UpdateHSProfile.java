package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Health_Supporter;
import models.Users;

public class UpdateHSProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String name;
	public String email;
	public String password;
//	public Users user_id;
	public String phone_number;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users user = new Users();
		user.id = (long) req.getSession().getAttribute("user_id");
		user.name = (String) req.getParameter("name");
		user.email = (String) req.getParameter("email");
		user.password = (String) req.getParameter("password");
		try {
			user.save();
		} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Object> hsList = Health_Supporter.select(Health_Supporter.class, "user_id = " + user.id);
		Health_Supporter hs = (Health_Supporter) hsList.get(0);
		hs.user_id = user;
		hs.phone_number = (String) req.getParameter("phone_number");
		try {
			hs.save();
		} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("edit_hs_profile").forward(req, resp);
	}	
}