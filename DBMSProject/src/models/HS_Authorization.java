package models;

import orm.BaseModel;

public class HS_Authorization extends BaseModel {
	public Patient pid;
	public Health_Supporter hsid; 
	public String auth_date; 
}