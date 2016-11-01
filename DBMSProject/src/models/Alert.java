package models;

import orm.BaseModel;

public class Alert extends BaseModel{
	public Patient pid;
	public Observation_Type oid;
	public Alert_Type tid;
	public String details;
	public int cleared;
	public Patient getPid() {
		return pid;
	}
	public void setPid(Patient pid) {
		this.pid = pid;
	}
	public Observation_Type getOid() {
		return oid;
	}
	public void setOid(Observation_Type oid) {
		this.oid = oid;
	}
	public Alert_Type getTid() {
		return tid;
	}
	public void setTid(Alert_Type tid) {
		this.tid = tid;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getCleared() {
		return cleared;
	}
	public void setCleared(int cleared) {
		this.cleared = cleared;
	}
	
	
	
}
