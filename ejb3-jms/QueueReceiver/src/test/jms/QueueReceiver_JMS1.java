package test.jms;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.model.vo.PersonData;

import test.config.JmsConfigVariables;
import test.constants.ApplicationConstants;

public class QueueReceiver_JMS1 extends JmsConfigVariables implements MessageListener {

	public void onMessage(Message msg) { // Listener
		System.out.println("Receiver invoked, fetching data...");
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
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		}
	}

	public void init(Context ctx, String queueName) throws NamingException, JMSException {
		connectionFactory = (QueueConnectionFactory) ctx.lookup(ApplicationConstants.JMS_FACTORY);
		connection = connectionFactory.createQueueConnection();
		session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup(queueName);
		receiver = session.createReceiver(queue);
		receiver.setMessageListener(this);
		connection.start();
	}

	public void close() throws JMSException {
		System.out.println("Closed");
		receiver.close();
		session.close();
		connection.close();
	}

	private static InitialContext getInitialContext(String url) throws NamingException {
		System.out.println("getting Initial Context");
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, ApplicationConstants.JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}

	public static void main(String[] args) throws Exception {
		String url = ApplicationConstants.JMS_URL;
		InitialContext ic = getInitialContext(url);
		QueueReceiver_JMS1 qr = new QueueReceiver_JMS1();
		qr.init(ic, ApplicationConstants.QUEUE);
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