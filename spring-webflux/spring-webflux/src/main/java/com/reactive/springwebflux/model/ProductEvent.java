package com.reactive.springwebflux.model;

public class ProductEvent {

	private Long eventId;

	private String eventType;

	public ProductEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductEvent(Long eventId, String eventType) {
		super();
		this.eventId = eventId;
		this.eventType = eventType;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventType=" + eventType + "]";
	}

}
