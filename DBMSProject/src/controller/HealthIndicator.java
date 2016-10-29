package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HealthIndicator extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String dob;
	public String patientCategory;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		ArrayList<HealthObservation> observationsList = new ArrayList<HealthObservation>();
		
		HealthObservation observations1 = new HealthObservation("Blood Pressure",
				"is the pressure exerted by circulating blood upon the walls of blood vessels.",
				70, 5, "Daily", 40, 80);
		HealthObservation observations2 = new HealthObservation("Temperature",
				"The normal body temperature of a person varies depending on gender.",
				80, 3, "Monthly", 30, 60);
		observationsList.add(observations1);
		observationsList.add(observations2);
		
		HashMap<String, ArrayList<RecordObservation>> recordedObservations = new HashMap<String, ArrayList<RecordObservation>>();
		RecordObservation obj1 = new RecordObservation("Temperature", "2015-5-3", "2015-2-3", "55");
		RecordObservation obj2 = new RecordObservation("Blood Pressure", "2009-5-3", "2009-2-3", "24");
		RecordObservation obj3 = new RecordObservation("Temperature", "2003-5-3", "2003-2-3", "13");
		RecordObservation[] arrayRecordObser = new RecordObservation[] {obj1, obj2, obj3};
		for (int i = 0; i < arrayRecordObser.length; i++) {
			RecordObservation objIter = arrayRecordObser[i];
			if (recordedObservations.containsKey(objIter.getType())) {
				recordedObservations.get(objIter.getType()).add(objIter);
			} else {
				ArrayList<RecordObservation> obserList = new ArrayList<RecordObservation>();
				obserList.add(objIter);
				recordedObservations.put(objIter.getType(), obserList);
			}
		}
		ArrayList<String> newObservations = new ArrayList<String>();
		newObservations.add("Temperature");
		newObservations.add("BloodPressure");
		newObservations.add("Weight");
		newObservations.add("Mood");
		
		req.setAttribute("observationsList", observationsList);
		req.setAttribute("recordedObservations", recordedObservations);
		req.setAttribute("newObservations", newObservations);

		req.getRequestDispatcher("healthInd.jsp").forward(req, res);
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
