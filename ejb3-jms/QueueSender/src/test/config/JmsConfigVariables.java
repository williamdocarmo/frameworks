package test.config;

import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

public class JmsConfigVariables {
	protected Message message;
	protected JMSContext jmsContext;
	protected QueueConnectionFactory connectionFactory;
	protected TopicConnectionFactory topicConnectionFactory;
	protected QueueConnection connection;
	protected TopicConnection topicConnection;
	protected QueueSession session;
	protected TopicSession topicSession;
	protected QueueSender sender;
	protected TopicPublisher topicPublisher;
	protected Queue queue;
	protected Topic topic;
	protected QueueReceiver queueReceiver;
	protected TopicSubscriber topicSubscriber;
	protected boolean quit = false;
}
