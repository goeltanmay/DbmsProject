package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddRecords extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String[] observType = req.getParameterValues("observType");
		String observTime, recordTime, observValue;
		for (int i = 0; i < observType.length; i++) {
			observTime = req.getParameter("observTime_" + observType[i]);
			recordTime = req.getParameter("recordTime_" + observType[i]);
			observValue = req.getParameter("observValue_" + observType[i]);
		}
		
		res.sendRedirect("successRecordsUpdate.jsp");
    }

}
