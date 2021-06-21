package test.jms;

import java.util.Hashtable;

import javax.jms.JMSConsumer;
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

public class QueueReceiver_JMS2_ extends JmsConfigVariables {

	public static void main(String[] args) throws Exception {
		QueueReceiver_JMS2_ qr = new QueueReceiver_JMS2_();
		qr.init(ApplicationConstants.QUEUE);
		qr.onMessage();
		qr.close();
	}

	public void init(String queueName) throws NamingException, JMSException {
		InitialContext ctx = getInitialContext(ApplicationConstants.JMS_URL);
		connectionFactory = (QueueConnectionFactory) ctx.lookup(ApplicationConstants.JMS_FACTORY);
		queue = (Queue) ctx.lookup(queueName);
	}

	private void onMessage() {
		try (JMSContext context = connectionFactory.createContext()) {
			JMSConsumer consumer = context.createConsumer(queue);
			PersonData person = consumer.receiveBody(PersonData.class);
			System.out.println("Retrieved Object: " + person);
		}
	}

	public void close() throws JMSException {
		System.out.println("Closed");
	}

	private static InitialContext getInitialContext(String url) throws NamingException {
		System.out.println("getting Initial Context");
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, ApplicationConstants.JNDI_FACTORY);
		env.put(Context.PROVIDER_URL, url);
		return new InitialContext(env);
	}

}