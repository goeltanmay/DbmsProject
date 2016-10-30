package models;

import orm.BaseModel;

public class Ordinal_Observation_Type extends BaseModel {
	
	public Patient pid;
	public Disease_Type did;
	public Observation_Type oid;
	public int frequency;
//	public String value;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Math.toIntExact(id);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordinal_Observation_Type other = (Ordinal_Observation_Type) obj;
		if (id != other.id)
			return false;
		return true;
	} 
}
