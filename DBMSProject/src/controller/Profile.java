package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Profile extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String email;
	public String password;
	public String gender;
	public String address;
	public String dob;
	public String patientCategory;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		/*setEmail(req.getParameter("name"));
		setEmail(req.getParameter("email"));
		setPassword(req.getParameter("password"));
		setGender(req.getParameter("gender"));
		setAddress(req.getParameter("address"));
		setDob(req.getParameter("dob"));//2013-2-25
		*/	
		req.setAttribute("name", "Aditya Pandey");
		req.setAttribute("email", "apandey6333");
		req.setAttribute("dob", "2015-08-08");//Set date like 2015-08-08
		req.setAttribute("gender", "o");
		req.setAttribute("address", "1520 Lilley");
		req.setAttribute("patientCategory", "Well Patient");
		req.getRequestDispatcher("profile.jsp").forward(req, res);
    }

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getPatientCategory() {
		return patientCategory;
	}

	public void setPatientCategory(String patientCategory) {
		this.patientCategory = patientCategory;
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
