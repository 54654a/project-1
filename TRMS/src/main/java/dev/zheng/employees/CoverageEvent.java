package dev.zheng.employees;

public class CoverageEvent {
	private int eventId;
	private String eventType;
	private double coverage;
	
	public CoverageEvent() {
		super();
	}
	
	public CoverageEvent(int eventId, String eventType, double coverage) {
		super();
		this.eventId = eventId;
		this.eventType = eventType;
		this.coverage = coverage;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public double getCoverage() {
		return coverage;
	}
	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}

	@Override
	public String toString() {
		return "Coverage Event [eventId=" + eventId + ", eventType=" + eventType + ", coverage=" + coverage + "]";
	}
	
}
