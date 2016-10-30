package models;

import java.util.ArrayList;

import orm.BaseModel;

public class Observation_Type extends BaseModel {

	public String name, Observ_metric;
	
	public static ArrayList<Object> getOrdinalObservationTypesForPatient(Patient p){
		String where = "pid = " + p.id;
		ArrayList<Object> ordinals = Ordinal_Observation_Type.select(Ordinal_Observation_Type.class, where);
		return ordinals;
	}
	
	public static ArrayList<Object> getNominalObservationTypesForPatient(Patient p){
		String where = "pid = " + p.id;
		ArrayList<Object> nominals = Nominal_Observation_Type.select(Nominal_Observation_Type.class, where);
		return nominals;
	}
	
	public static ArrayList<Object> getNominalObservationTypeForDisease(Disease_Type d){
		String where = "pid is null and did = " + d.id;
		ArrayList<Object> nominals = Nominal_Observation_Type.select(Nominal_Observation_Type.class, where);
		return nominals;
	}
	
	public static ArrayList<Object> getOrdinalObservationTypeForDisease(Disease_Type d){
		String where = "pid is null and did = " + d.id;
		ArrayList<Object> nominals = Ordinal_Observation_Type.select(Ordinal_Observation_Type.class, where);
		return nominals;
	}
	
	public static ArrayList<Object> getNominalObservationTypeForAll(){
		String where = "pid is null and did is null";
		ArrayList<Object> nominals = Nominal_Observation_Type.select(Nominal_Observation_Type.class, where);
		return nominals;
	}
	
	public static ArrayList<Object> getOrdinalObservationTypeForAll(){
		String where = "pid is null and did is null";
		ArrayList<Object> nominals = Ordinal_Observation_Type.select(Ordinal_Observation_Type.class, where);
		return nominals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Observation_Type other = (Observation_Type) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getObserv_metric() {
		return Observ_metric;
	}

	public void setObserv_metric(String observ_metric) {
		Observ_metric = observ_metric;
	}

}
