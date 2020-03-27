import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class JavaKafkaProducer {

	public static void main(String[] args) throws Exception {
		
		String bootstrapServer = args[0]+":9092";

		String topicName = "USER_REGISTERED_TOPIC";
		Properties props = new Properties();
		props.put("bootstrap.servers", bootstrapServer);
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		// Producer<Object, Object> producer = new KafkaProducer<Object, Object>(props);
		// ProducerRecord<Object, Object> record = new ProducerRecord<Object, Object>(topicName, "message-key", "message-value");
		
		Producer producer = new KafkaProducer(props);
		ProducerRecord record = new ProducerRecord(topicName, "message-key", "message-value");
		producer.send(record);
		producer.close();

	}
}