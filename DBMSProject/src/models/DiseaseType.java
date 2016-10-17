package models;

import orm.BaseModel;

public class DiseaseType extends BaseModel {
	
	public String disease_name;

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
