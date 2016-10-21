package controller;


public class RecordObservation {
	public String type;
	public String observTime;
	public String recordTime;
	public String observValue;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getObservTime() {
		return observTime;
	}
	
	public void setObservTime(String observTime) {
		this.observTime = observTime;
	}
	
	public String getRecordTime() {
		return recordTime;
	}
	
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	
	public String getObservValue() {
		return observValue;
	}
	
	public void setObservValue(String observValue) {
		this.observValue = observValue;
	}

	public RecordObservation(String type, String observTime, String recordTime,
			String observValue) {
		super();
		this.type = type;
		this.observTime = observTime;
		this.recordTime = recordTime;
		this.observValue = observValue;
	}
	
}
