package models;

import orm.BaseModel;

public class Record_NOM_OBS_Type extends BaseModel{
	public Users getUserid() {
		return userid;
	}
	public void setUserid(Users userid) {
		this.userid = userid;
	}
	public Disease_Type getDid() {
		return did;
	}
	public void setDid(Disease_Type did) {
		this.did = did;
	}
	public Observation_Type getOid() {
		return oid;
	}
	public void setOid(Observation_Type oid) {
		this.oid = oid;
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
	public Users userid;
	public Disease_Type did;
	public Observation_Type oid;
	int readings;
	public String recording_timestamp, observation_timestamp;
}
