package com.app.kafka;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import com.app.kafka.model.User;

public class JavaKafkaConsumer {

	private String BOOTSTRAP_SERVER = "localhost:9094";
	private String TOPIC_1 = "USER_TOPIC_1";
	private String TOPIC_2 = "USER_TOPIC_2";

	public static void main(String[] args) throws Exception {
		JavaKafkaConsumer kafkaProducer = new JavaKafkaConsumer();
		kafkaProducer.testConsumer();
	}

	private void testConsumer() throws InterruptedException, ExecutionException {
		Properties props = getKafkaProperties();
		KafkaConsumer<String, User> consumer = new KafkaConsumer<String, User>(props);

		try {
		    consumer.subscribe(Collections.singletonList(TOPIC_1));
		    while (true) {
		        ConsumerRecords<String, User> messages = consumer.poll(Duration.ofMillis(100));
		        for (ConsumerRecord<String, User> message : messages) {
		          System.out.println("Message received " + message.value().toString());
		        }
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
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.app.kafka.deserializer.UserDeserializer");
		props.put(ConsumerConfig.GROUP_ID_CONFIG, TOPIC_1);
		return props;
	}
}