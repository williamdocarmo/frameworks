package test.jms;

import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;

import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.model.vo.PersonData;

import test.config.JmsConfigVariables;
import test.constants.ApplicationConstants;

public class QueueTransmitter_JMS2 extends JmsConfigVariables {

	public static void main(String args[]) {
		QueueTransmitter_JMS2 tx = new QueueTransmitter_JMS2();
		try {
			tx.initializeQueue(ApplicationConstants.JMS_URL);
			// tx.sendOrderJms("Hello!");
			tx.sendMessage(new PersonData("Santanu", "Bhattacharyya", 26, 41255));
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
		queue = (Queue) ctx.lookup(queueName);
	}

	public void sendMessage(Object obj) throws JMSException, NamingException {
		send((Serializable) obj);
		System.out.println("Message sent...");
		close();
	}

	public void send(Serializable obj) throws JMSException {
		try (JMSContext jmsContext = connectionFactory.createContext()) {
			if (obj instanceof String) {
				message = jmsContext.createTextMessage(obj.toString());
			} else {
				message = jmsContext.createObjectMessage(obj);
			}
			message.setJMSCorrelationID("CorrelationID: " + new Date());
			jmsContext.createProducer().send(queue, message);
		}

	}

	public void close() throws JMSException {
	}

}