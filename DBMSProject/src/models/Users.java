package models;

import orm.BaseModel;

public class Users extends BaseModel {
	
	public String name;
	public String email;
	public String password;
	public String gender;
	public String address;
	public String dob;

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
