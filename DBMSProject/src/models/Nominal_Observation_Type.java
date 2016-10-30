package models;

import orm.BaseModel;

public class Nominal_Observation_Type extends BaseModel {

	public Patient pid;
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
		Nominal_Observation_Type other = (Nominal_Observation_Type) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Disease_Type did;
	public Observation_Type oid;
	public int upper_limit, lower_limit, frequency;
//	public String value;
	public Patient getPid() {
		return pid;
	}
	public void setPid(Patient pid) {
		this.pid = pid;
	}
	public Disease_Type getDid() {
		return did;
	}
	public void setDid(Disease_Type did) {
		this.did = did;
	}
	public Observation_Type getOid() {
		return oid;
	}
	public void setOid(Observation_Type oid) {
		this.oid = oid;
	}
	public int getUpper_limit() {
		return upper_limit;
	}
	public void setUpper_limit(int upper_limit) {
		this.upper_limit = upper_limit;
	}
	public int getLower_limit() {
		return lower_limit;
	}
	public void setLower_limit(int lower_limit) {
		this.lower_limit = lower_limit;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
