package com.app.kafka;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.app.kafka.model.User;

public class JavaKafkaProducer {

	private String BOOTSTRAP_SERVER = "localhost:9092";
	private String TOPIC = "NEW_USER_TOPIC";

	public static void main(String[] args) throws Exception {
		JavaKafkaProducer kafkaProducer = new JavaKafkaProducer();
		kafkaProducer.testStringProducer();
	}

	private void testStringProducer() throws InterruptedException, ExecutionException {
		Properties props = getKafkaProperties();

		Producer<String, String> stringProducer = new KafkaProducer<String, String>(props);
		for (int i = 1; i <= 100; i++) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, "message-key-"+i, "message-value-"+i);
			Future<RecordMetadata> recordMetadata = stringProducer.send(record);
			System.out.println(recordMetadata.get().serializedKeySize() + " "+ recordMetadata.get().serializedValueSize() + " " + recordMetadata.get().partition());
		}
		stringProducer.close();
	}
	
	private void testUserProducer() throws InterruptedException, ExecutionException {
		Properties props = getKafkaProperties();

		Producer<String, User> userProducer = new KafkaProducer<String, User>(props);
		for (int i = 1; i <= 100; i++) {
			ProducerRecord<String, User> record = new ProducerRecord<String, User>(TOPIC, "user-key-"+i, new User("user-name-"+i, "secret-code-"+i));
			Future<RecordMetadata> recordMetadata = userProducer.send(record);
			System.out.println(recordMetadata.get().serializedKeySize() + " "+ recordMetadata.get().serializedValueSize() + " " + recordMetadata.get().partition());
		}
		userProducer.close();
	}

	private Properties getKafkaProperties() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
		/**
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 50);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		*/
		return props;
	}
}