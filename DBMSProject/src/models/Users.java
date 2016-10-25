package models;

import orm.BaseModel;

public class Users extends BaseModel {
	
	public String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String email;
	public String password;

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
