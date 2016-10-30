package models;

import orm.BaseModel;

public class Diagnosis extends BaseModel
{
	public Patient pid;
	public Disease_Type did;
	public String Diagnosis_Date;
}
