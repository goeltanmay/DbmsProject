package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Patient;
import models.Users;
import models.Well_Patient;

/**
 * Servlet implementation class PatientSignUp
 */
@WebServlet("/PatientSignUp")
public class PatientSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		Patient p=new Patient();
		p.user_id = new Users();
		p.user_id.id=(long) request.getSession().getAttribute("user_id");
		
		
		p.gender=request.getParameter("gender");
		p.address=request.getParameter("address");
		p.dob=request.getParameter("dob");
		
		request.getSession().setAttribute("patient_id",request.getSession().getAttribute("user_id"));
		
		RequestDispatcher rd=null;
		
		try {
			p.save();
			Well_Patient wp = new Well_Patient();
			wp.pid = p;
			wp.hsid1 = null;
			wp.hsid2 = null;
			wp.save();
			rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request,response);
			
		} catch (NullPointerException | IllegalArgumentException
				| IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rd=request.getRequestDispatcher("signUpError.jsp");
			rd.forward(request,response);
		}
		

		
	}

}
