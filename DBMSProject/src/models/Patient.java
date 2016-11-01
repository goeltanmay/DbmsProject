package models;

import java.sql.SQLException;
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
	
	public void setHealthSupporter(String role, Health_Supporter hs,String authDate) throws NullPointerException, IllegalArgumentException, IllegalAccessException, SQLException{
		String where = "pid = " + this.id;
		ArrayList<Object> sick_patients = Sick_Patient.select(Sick_Patient.class, where);
		if(sick_patients.size()>0){
			Sick_Patient s = (Sick_Patient) sick_patients.get(0);
			if(role.equalsIgnoreCase("primary")){
				s.hsid1 = hs;
				try {
					s.save();
				} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				s.hsid2 = hs;
				try {
					s.save();
				} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		ArrayList<Object> well_patients = Well_Patient.select(Well_Patient.class, where);
		if(well_patients.size()>0){
			Well_Patient s = (Well_Patient) well_patients.get(0);
			if(role.equalsIgnoreCase("primary")){
				s.hsid1 = hs;
				try {
					s.save();
				} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				s.hsid2 = hs;
				try {
					s.save();
				} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//write code for entry into health authorization
		
		HS_Authorization hsa=new HS_Authorization();
		hsa.pid=this;
		hsa.hsid=hs;
		hsa.auth_date=authDate;
		hsa.save();
		
	}
	
	public void remove_hs(Health_Supporter hs){
		String where = "pid = " + this.id;
		ArrayList<Object> sick_patients = Sick_Patient.select(Sick_Patient.class, where);
		if(sick_patients.size()>0){
			Sick_Patient s = (Sick_Patient) sick_patients.get(0);
			if(hs.id == s.hsid1.id){
				if(s.hsid2 != null){
					s.hsid1 = s.hsid2;
					s.hsid2 = null;
				}
				else s.hsid1= null;
				try {
					s.save();
				} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(s.hsid2 != null )
				if(hs.id == s.hsid2.id){
					s.hsid2 = null;
					try {
						s.save();
					} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
		ArrayList<Object> well_patients = Well_Patient.select(Well_Patient.class, where);
		if(well_patients.size()>0){
			Well_Patient s = (Well_Patient) well_patients.get(0);
			if(s.hsid1 != null)
				if(hs.id == s.hsid1.id){
					if(s.hsid2 != null){
						s.hsid1 = s.hsid2;
						s.hsid2 = null;
					}
					else s.hsid1= null;
					try {
						s.save();
					} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			if(s.hsid2 != null)
				if(hs.id == s.hsid2.id){
					s.hsid2 = null;
					try {
						s.save();
					} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
	}
	
	public boolean isSick(){
		String where = "pid = " + this.id;
		ArrayList<Object> sick_patients = Sick_Patient.select(Sick_Patient.class, where);
		if(sick_patients.size()>0) 
			return true;
		return false;
	}
	
	public void changeToSick(){
		String where = "pid = " + this.id;
		ArrayList<Object> well_patients = Well_Patient.select(Well_Patient.class, where);
		Well_Patient wp = (Well_Patient) well_patients.get(0);
		Sick_Patient sp = new Sick_Patient();
		sp.pid = this;
		sp.hsid1 = wp.hsid1;
		sp.hsid2 = wp.hsid2;
		try {
			sp.save();
			wp.delete();
		} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeToWell(){
		// assuming person is already sick.
		String where = "pid = " + this.id;
		ArrayList<Object> sick_patients = Sick_Patient.select(Sick_Patient.class, where);
		Sick_Patient s = (Sick_Patient) sick_patients.get(0);
		Well_Patient wp = new Well_Patient();
		wp.pid = this;
		wp.hsid1 = s.hsid1;
		wp.hsid2 = s.hsid2;
		try {
			wp.save();
			s.delete();
		} catch (NullPointerException | IllegalArgumentException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Disease_Type> getDiseases(){
		String where = "pid = " + this.id;
		ArrayList<Disease_Type> diseases = new ArrayList<Disease_Type>();
		ArrayList<Object> diagnosis = Diagnosis.select(Diagnosis.class, where);
		for( Object d : diagnosis){
			if(d != null)
				diseases.add(((Diagnosis)d).did);
		}
		return diseases;
	}

}
