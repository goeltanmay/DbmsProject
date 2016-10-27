package controller;

public class Diag {
	String name;
	String date;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	Diag(String name, String date) {
		this.name = name;
		this.date = date;
	}
	
	Diag(String name) {
		this.name = name;
	}
}
