package test.config;

import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import test.jms.TopicTransmitter;

public class JmsConfigVariables {
	protected TopicConnectionFactory topicConnectionFactory;
	protected TopicConnection topicConnection;
	protected TopicSession topicSession;
	protected TopicPublisher topicPublisher;
	protected Topic topic;
	protected ObjectMessage message;
	protected TopicSubscriber topicSubscriber;
	protected boolean quit = false;
	protected static TopicTransmitter tx = new TopicTransmitter();
}
