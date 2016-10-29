package models;

import java.util.ArrayList;

import orm.BaseModel;

public class Patient extends BaseModel{

	public Users user_id;
	public String dob;
	public String address;
	public String gender;
	
	public ArrayList<Health_Supporter> getHealthSupporters(){
		String where = "pid = " + this.id;
		Health_Supporter hs_id1 = null;
		Health_Supporter hs_id2 = null;
		ArrayList<Object> sick_patients = Sick_Patient.select(Sick_Patient.class, where);
		if(sick_patients.size()>0){
			Sick_Patient s = (Sick_Patient) sick_patients.get(0);
			hs_id1 = s.hsid1;
			hs_id2 = s.hsid2;
		}
		ArrayList<Object> well_patients = Well_Patient.select(Well_Patient.class, where);
		if(well_patients.size()>0){
			Well_Patient well_patient = (Well_Patient) well_patients.get(0);
			hs_id1 = well_patient.hsid1;
			hs_id2 = well_patient.hsid2;
		}
		ArrayList<Health_Supporter> hss = new ArrayList();
		hss.add(hs_id1);
		hss.add(hs_id2);
		return hss;
		// now that we have hsids , we can look for HSID objects.
	}

}
