package webclient.model;

public class ProductEvent {

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
