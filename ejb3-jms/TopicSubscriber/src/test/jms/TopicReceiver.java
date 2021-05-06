package test.jms;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import test.config.JmsConfigVariables;
import test.constants.ApplicationConstants;

import com.vo.PersonData;

public class TopicReceiver extends JmsConfigVariables implements MessageListener {

	public void onMessage(Message msg) { // Listener
		try {
			String msgText;
			if (msg instanceof TextMessage) {
				msgText = ((TextMessage) msg).getText();
			} else {
				msgText = msg.toString();
			}
			System.out.println("Object Message Received: " + msgText);
			ObjectMessage obj = (ObjectMessage) msg;
			if (obj.getObject() instanceof PersonData) {
				PersonData person = (PersonData) obj.getObject();
				System.out.println("Person Name: " + person.getFirstName());
			}

			if (msgText.equalsIgnoreCase("quit")) {
				synchronized (this) {
					quit = true;
					this.notifyAll(); // Notify main thread to quit
				}
			}
		} catch (JMSException jmse) {
			System.err.println("An exception occurred: " + jmse.getMessage());
		}
	}

	public void init(Context ctx, String topicName) throws NamingException,
			JMSException {
		topicConnectionFactory = (TopicConnectionFactory) ctx
				.lookup(ApplicationConstants.JMS_CONNECTION_FACTORY);
		topicConnection = topicConnectionFactory.createTopicConnection();
		topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		topic = (Topic) ctx.lookup(topicName);
		topicSubscriber = topicSession.createSubscriber(topic);
		topicSubscriber.setMessageListener(this);
		topicConnection.start();
	}

	public void close() throws JMSException {
		topicSubscriber.close();
		topicSession.close();
		topicConnection.close();
	}

	private static InitialContext getInitialContext(String url)
			throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				ApplicationConstants.JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}

	public static void main(String[] args) throws Exception {
		String url = ApplicationConstants.JMS_URL;
		InitialContext ic = getInitialContext(url);
		TopicReceiver qr = new TopicReceiver();
		qr.init(ic, ApplicationConstants.TOPIC);
		synchronized (qr) {
			while (!qr.quit) {
				try {
					qr.wait();
				} catch (InterruptedException ie) {
				}
			}
		}
		qr.close();
	}
}