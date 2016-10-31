package models;

import orm.BaseModel;

public class Records_ORD_OBS_Type extends BaseModel {
	public Users userid;
	public Ordinal_Observation_Type ooid;
	public String recording_timestamp, observation_timestamp;
	public Ordinal_Observation_Values readings;
	public Patient pid;
	public Users getUserid() {
		return userid;
	}
	public void setUserid(Users userid) {
		this.userid = userid;
	}
	
	public Ordinal_Observation_Type getOid() {
		return ooid;
	}
	public void setOid(Ordinal_Observation_Type oid) {
		this.ooid = oid;
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
	public Ordinal_Observation_Values getReadings() {
		return readings;
	}
	public void setReadings(Ordinal_Observation_Values readings) {
		this.readings = readings;
	}
}
