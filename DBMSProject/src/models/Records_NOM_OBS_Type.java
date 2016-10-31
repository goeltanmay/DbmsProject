package models;

import orm.BaseModel;

public class Records_NOM_OBS_Type extends BaseModel{
	public Users userid;
	public Observation_Type noid;
	public int readings;
	public String recording_timestamp, observation_timestamp;
	public Patient pid;
	
	public Users getUserid() {
		return userid;
	}
	public void setUserid(Users userid) {
		this.userid = userid;
	}
	public Observation_Type getNoid() {
		return noid;
	}
	public void setOid(Observation_Type oid) {
		this.noid = oid;
	}
	public int getReadings() {
		return readings;
	}
	public void setReadings(int readings) {
		this.readings = readings;
	}
	public String getRecording_timestamp() {
		return recording_timestamp;
	}
	public void setRecording_timestamp(String recording_timestamp) {
		this.recording_timestamp = recording_timestamp;
	}
	public String getObservation_timestamp() {
		return observation_timestamp;
	}
	public void setObservation_timestamp(String observation_timestamp) {
		this.observation_timestamp = observation_timestamp;
	}
	
}
