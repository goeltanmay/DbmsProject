package models;

import orm.BaseModel;

public class Ordinal_Observation_Type extends BaseModel {
	
	public Patient pid;
	public Disease_Type did;
	public Observation_Type oid;
	public int frequency, value; 
}
