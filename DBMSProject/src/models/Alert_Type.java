package models;

import orm.BaseModel;

public class Alert_Type extends BaseModel{

	public String Description;

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
}
