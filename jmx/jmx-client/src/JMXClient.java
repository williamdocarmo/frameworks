import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import javax.management.AttributeChangeNotification;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JMXClient {

	public static void main(String[] args) throws IOException, MalformedObjectNameException, InstanceNotFoundException,
			IntrospectionException, ReflectionException {
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9000/jmxrmi");
		JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
		MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

		ClientListener listener = new ClientListener();
		
		waitForEnterPressed();
		
		echo("\nDomains:");
		String domains[] = mbsc.getDomains();
		Arrays.sort(domains);
		for (String domain : domains) {
			echo("\tDomain = " + domain);
		}
		
		waitForEnterPressed();
		
		echo("\nMBeanServer default domain = " + mbsc.getDefaultDomain());
		echo("\nMBean count = " + mbsc.getMBeanCount());
		echo("\nQuery MBeanServer MBeans:");
		
		Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null, null));
		for (ObjectName name : names) {
			echo("\tObjectName = " + name);
		}
		
		waitForEnterPressed();
		
		ObjectName objectName = new ObjectName("com.app.jmx:type=basic,name=config");
		mbsc.addNotificationListener(objectName, listener, null, null);
		
		ApplicationConfigurationMBean mbeanProxy = JMX.newMBeanProxy(mbsc, objectName,
				ApplicationConfigurationMBean.class, true);
		
		echo("Existing Password: "+mbeanProxy.getPassword());
		
		mbeanProxy.setPassword("Client Set Password");
		
		echo("\nWaiting for notification...");
		sleep(2000);
		echo("\nNew Password = " + mbeanProxy.getPassword());
		
		waitForEnterPressed();
		
		mbeanProxy.resetOperation(true, "default");

		System.out.println(mbeanProxy.displayConfiguration(true));

		mbeanProxy.setPassword("new password");
		
		echo("\nClose the connection to the server");
		jmxc.close();
		echo("\nBye! Bye!");
	}

	

	public static class ClientListener implements NotificationListener {
		public void handleNotification(Notification notification, Object handback) {
			echo("\nReceived notification:");
			echo("\tClassName: " + notification.getClass().getName());
			echo("\tSource: " + notification.getSource());
			echo("\tType: " + notification.getType());
			echo("\tMessage: " + notification.getMessage());
			if (notification instanceof AttributeChangeNotification) {
				AttributeChangeNotification acn = (AttributeChangeNotification) notification;
				echo("\tAttributeName: " + acn.getAttributeName());
				echo("\tAttributeType: " + acn.getAttributeType());
				echo("\tNewValue: " + acn.getNewValue());
				echo("\tOldValue: " + acn.getOldValue());
			}
		}

	}
	
	private static void waitForEnterPressed() {
		try {
			echo("\nPress <Enter> to continue...");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void echo(String msg) {
		System.out.println(msg);
	}
	
	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
