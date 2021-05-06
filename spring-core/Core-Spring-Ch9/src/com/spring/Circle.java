package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component (value = "circle")
public class Circle implements Shape, ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher publisher;
	
	private Point center;

	@Autowired
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		DrawEvent event = new DrawEvent(this);
		publisher.publishEvent(event);
	}
	
	@Override
	public String toString() {
		return "[center=" + center + "]";
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
		
	}
	
}
