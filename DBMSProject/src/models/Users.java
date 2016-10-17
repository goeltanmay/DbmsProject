package models;

import orm.BaseModel;

public class Users extends BaseModel {
	
	public String name;
	public String email;
	public String password;

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BaseModel update() {
		// TODO Auto-generated method stub
		return this;
	}

}
