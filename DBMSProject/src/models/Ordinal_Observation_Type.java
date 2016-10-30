package models;

import orm.BaseModel;

public class Ordinal_Observation_Type extends BaseModel {
	
	public Patient pid;
	public Disease_Type did;
	public Observation_Type oid;
	public int frequency;
	public String expected;
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
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public String getExpected() {
		return expected;
	}
	public void setExpected(String expected) {
		this.expected = expected;
	} 
}
