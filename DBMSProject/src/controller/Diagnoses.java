package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Diagnoses extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String dob;
	public String patientCategory;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		ArrayList<String> diagnos = new ArrayList<String>();
		diagnos.add("\"HIV\"");
		diagnos.add("\"Chicken Pox\"");
		diagnos.add("\"TB\"");
		diagnos.add("\"Malaria\"");
		req.setAttribute("existDiag", diagnos);

		ArrayList<String> remainDiag = new ArrayList<String>();
		remainDiag.add("\"Cancer\"");
		remainDiag.add("\"Diabetes\"");
		remainDiag.add("\"Heart Disease\"");
		remainDiag.add("\"Flu\"");
		req.setAttribute("remainDiag", remainDiag);
		
		req.getRequestDispatcher("diagnoses.jsp").forward(req, res);
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
