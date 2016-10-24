package models;

import orm.BaseModel;

public class Patient extends BaseModel{

	public Users user_id;
	public String dob;
	public String address;
	public String gender;

}
