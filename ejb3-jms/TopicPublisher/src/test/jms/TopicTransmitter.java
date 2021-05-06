package test.jms;

import java.io.Serializable;
import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import test.config.JmsConfigVariables;
import test.constants.ApplicationConstants;

import com.model.vo.PersonData;

public class TopicTransmitter extends JmsConfigVariables {

	public static void main(String args[]) {
		try {
			tx.initializeTopic(ApplicationConstants.JMS_URL);
			tx.sendOrderJms(new PersonData("Ratul", "Android", 25, 1234));
		} catch (Exception e) {
			System.out.println("Caught exception while communicating with JMS");
			e.printStackTrace();
		}
	}

	private void initializeTopic(String jmsUrl) throws NamingException, JMSException {
		InitialContext ic = getInitialContext(ApplicationConstants.JMS_URL);
		init(ic, ApplicationConstants.TOPIC);
	}

	public void sendOrderJms(Object obj) throws JMSException, NamingException {

		send((Serializable) obj);
		close();
	}

	private InitialContext getInitialContext(String url) throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, ApplicationConstants.JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}

	public void init(Context ctx, String topicName) throws NamingException, JMSException {
		topicConnectionFactory = (TopicConnectionFactory) ctx.lookup(ApplicationConstants.JMS_FACTORY);
		topicConnection = topicConnectionFactory.createTopicConnection();
		topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup(topicName);
		topicPublisher = topicSession.createPublisher(topic);
		message = topicSession.createObjectMessage();
		topicConnection.start();
	}

	public void send(Serializable obj) throws JMSException {
		message.setObject(obj);
		topicPublisher.send(message);
		System.out.println("Message Sent to Topic...");
	}

	public void close() throws JMSException {
		topicPublisher.close();
		topicSession.close();
		topicConnection.close();
	}

}