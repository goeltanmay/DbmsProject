package models;

import orm.BaseModel;

public class Well_Patient extends BaseModel{

	public Patient pid;
	public Health_Supporter hsid1, hsid2;
}
