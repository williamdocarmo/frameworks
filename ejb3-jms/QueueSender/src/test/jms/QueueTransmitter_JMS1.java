package test.jms;

import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
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
import weblogic.jms.common.Destination;

public class QueueTransmitter_JMS1 extends JmsConfigVariables {

	public static void main(String args[]) {

		QueueTransmitter_JMS1 tx = new QueueTransmitter_JMS1();
		try {
			tx.initializeQueue(ApplicationConstants.JMS_URL);
			tx.sendMessage("Hello, JMS!");
			// tx.sendMessage(new PersonData("Santanu", "Bhattacharyya", 26, 41255));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initializeQueue(String jmsUrl) throws NamingException, JMSException {
		String url = ApplicationConstants.JMS_URL;
		if (null != url) {
			InitialContext ic = getInitialContext(url);
			init(ic, ApplicationConstants.QUEUE);
		}
	}

	private InitialContext getInitialContext(String url) throws NamingException {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, ApplicationConstants.JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}

	public void init(Context ctx, String queueName) throws NamingException, JMSException {
		connectionFactory = (QueueConnectionFactory) ctx.lookup(ApplicationConstants.JMS_FACTORY);
		connection = connectionFactory.createQueueConnection();
		session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		queue = (Queue) ctx.lookup(queueName);
		sender = session.createSender(queue);
		connection.start();
	}

	public void sendMessage(Object obj) throws JMSException, NamingException {
		send((Serializable) obj);
		System.out.println("Message sent...");
		close();
	}

	public void send(Serializable obj) throws JMSException {
		if (obj instanceof String) {
			message = session.createTextMessage(obj.toString());
		} else {
			message = session.createObjectMessage(obj);
		}
		message.setJMSCorrelationID("CorrelationID: " + new Date());
		message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
		message.setJMSPriority(3);
		message.setStringProperty("prop1", "value1");
		sender.send(message);
	}

	public void close() throws JMSException {
		sender.close();
		session.close();
		connection.close();
	}

}