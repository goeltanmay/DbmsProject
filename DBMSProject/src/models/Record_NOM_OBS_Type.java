package models;

import orm.BaseModel;

public class Record_NOM_OBS_Type extends BaseModel{
	public Users userid;
	public Disease_Type did;
	public Observation_Type oid;
	int readings;
	public String recording_timestamp, observation_timestamp;
}
