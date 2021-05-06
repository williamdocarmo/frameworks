package com.app.kafka;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.internals.Fetcher;
import org.apache.kafka.common.TopicPartition;

import com.app.kafka.model.User;

public class JavaKafkaConsumer3 {

	private String BOOTSTRAP_SERVER = "localhost:9092";
	private String TOPIC_1 = "NEW_USER_TOPIC";
	private String TOPIC_2 = "USER_TOPIC_2";

	public static void main(String[] args) throws Exception {
		JavaKafkaConsumer3 kafkaProducer = new JavaKafkaConsumer3();
		kafkaProducer.testConsumer2();
	}

	private void testConsumer1() throws InterruptedException, ExecutionException {
		Properties props = getKafkaProperties();
		KafkaConsumer<String, User> consumer = new KafkaConsumer<String, User>(props);

		try {
		    consumer.subscribe(Collections.singletonList(TOPIC_1));
		    while (true) {
		        ConsumerRecords<String, User> messages = consumer.poll(Duration.ofMillis(5000));
		        messages.forEach((message)->processMessage(message.value()));
		        consumer.commitSync();
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			consumer.close();
		}
	}
	
	private void testConsumer2() throws InterruptedException, ExecutionException {
		Properties props = getKafkaProperties();
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

		try {
		    consumer.subscribe(Collections.singletonList(TOPIC_1));
		    while (true) {
		        ConsumerRecords<String, String> messages = consumer.poll(Duration.ofMillis(5000));
		        messages.forEach((message)->System.out.println(String.format("Topic: %s, Partition: %s, Message: %s", message.topic(), message.partition(), message.value())));
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			consumer.close();
		}
	}
	
	private void testPartition() throws InterruptedException, ExecutionException {
		Properties props = getKafkaProperties();
		KafkaConsumer<String, User> consumer = new KafkaConsumer<String, User>(props);
		
		try {
			ArrayList<TopicPartition> partitions = new ArrayList<TopicPartition>();
			partitions.add(new TopicPartition(TOPIC_1, 1));
			partitions.add(new TopicPartition(TOPIC_2, 2));
		    consumer.assign(partitions);
		    
		    while (true) {
		        ConsumerRecords<String, User> records = consumer.poll(Duration.ofMillis(100));
		        for (ConsumerRecord<String, User> record : records) {
		          System.out.println("Message received " + record.value().toString() + " "+record.partition());
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
			consumer.close();
		}
	}

	private Properties getKafkaProperties() {
		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "USER_CONSUMER_GROUP");
		return props;
	}
	
	private void processMessage(User user) {
		System.out.println("Retrieved User: "+user.toString());
	}
}