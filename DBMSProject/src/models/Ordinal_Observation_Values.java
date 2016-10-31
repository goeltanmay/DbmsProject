package models;

import orm.BaseModel;

public class Ordinal_Observation_Values extends BaseModel {
	public Ordinal_Observation_Type oid;
	public String value;
	public Ordinal_Observation_Type getOid() {
		return oid;
	}
	public void setOid(Ordinal_Observation_Type oid) {
		this.oid = oid;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
