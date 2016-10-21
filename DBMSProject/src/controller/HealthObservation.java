package controller;


public class HealthObservation {
	public String name;
	public String description;
	public int alertThreshold;
	public int recommFreq;
	public String recommFreqMetrics;
	public int upperLimit;
	public int lowerLimit;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAlertThreshold() {
		return alertThreshold;
	}
	public void setAlertThreshold(int alertThreshold) {
		this.alertThreshold = alertThreshold;
	}
	public int getRecommFreq() {
		return recommFreq;
	}
	public void setRecommFreq(int recommFreq) {
		this.recommFreq = recommFreq;
	}
	public String getRecommFreqMetrics() {
		return recommFreqMetrics;
	}
	public void setRecommFreqMetrics(String recommFreqMetrics) {
		this.recommFreqMetrics = recommFreqMetrics;
	}
	
	public int getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}
	public int getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public HealthObservation(String name, String description,
			int alertThreshold, int recommFreq, String recommFreqMetrics,
			int upperLimit, int lowerLimit) {
		super();
		this.name = name;
		this.description = description;
		this.alertThreshold = alertThreshold;
		this.recommFreq = recommFreq;
		this.recommFreqMetrics = recommFreqMetrics;
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
	}
}
