package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orm.BaseModel;


public class Diagnoses extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String dob;
	public String patientCategory;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		long pid=(long)req.getSession().getAttribute("patient_id");
		System.out.println("Patient id is:"+pid);
		ResultSet rs=null;
//		get diagnosis that already exists
//		get remaining diseases
		
		ArrayList<Diag> existingDiagnosis = new ArrayList<Diag>();
		ArrayList<Diag> remainingDiagnosis = new ArrayList<Diag>();
		
		try {
			rs=BaseModel.selectRaw("select dis.disease_name,diag.diagnosis_date from diagnosis diag,disease_type dis where diag.did=dis.id and diag.pid="+pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next())
			{		
				existingDiagnosis.add(new Diag(rs.getString(1),rs.getString(2)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*existingDiagnosis.add("\"Chicken Pox\"");
		existingDiagnosis.add("\"TB\"");
		existingDiagnosis.add("\"Malaria\"");*/
		
		
		req.setAttribute("existDiag", existingDiagnosis);

		try {
			rs=BaseModel.selectRaw("select disease_name from disease_type where id not in(select did from diagnosis where pid="+pid+")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next())
			{	
				remainingDiagnosis.add(new Diag(rs.getString(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("remainDiag", remainingDiagnosis);
		
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
