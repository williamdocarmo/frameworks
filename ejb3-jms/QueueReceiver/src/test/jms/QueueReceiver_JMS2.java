package test.jms;

import java.util.Hashtable;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.model.vo.PersonData;

import test.config.JmsConfigVariables;
import test.constants.ApplicationConstants;

public class QueueReceiver_JMS2 extends JmsConfigVariables {

	public static void main(String[] args) throws Exception {
		QueueReceiver_JMS2 qr = new QueueReceiver_JMS2();
		qr.init(ApplicationConstants.QUEUE);
		qr.close();
	}

	public void init(String queueName) throws NamingException, JMSException {
		InitialContext ctx = getInitialContext(ApplicationConstants.JMS_URL);
		connectionFactory = (QueueConnectionFactory) ctx.lookup(ApplicationConstants.JMS_FACTORY);
		queue = (Queue) ctx.lookup(queueName);
		JMSContext context = connectionFactory.createContext();
		JMSConsumer consumer = context.createConsumer(queue);
		consumer.setMessageListener(msg -> {

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
		});
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