package com.reactive.springwebfluxfunctional.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductEvent {

	@Id
	private long eventId;

	private String eventType;

	public ProductEvent() {
		super();
	}

	public ProductEvent(long eventId, String eventType) {
		super();
		this.eventId = eventId;
		this.eventType = eventType;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
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
		return "ProductEvent [eventId=" + eventId + ", eventType=" + eventType + "]";
	}

}
