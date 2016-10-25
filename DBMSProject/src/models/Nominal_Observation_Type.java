package models;

import orm.BaseModel;

public class Nominal_Observation_Type extends BaseModel {

	public Patient pid;
	public Disease_Type did;
	public Observation_Type oid;
	public int upper_limit, lower_limit, frequency, value;
}
