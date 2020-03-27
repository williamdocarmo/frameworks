package com.mycompany.email.kafka.consumer;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "USER_REGISTERED_TOPIC")
    public void receive(Object payload) {
        LOGGER.info("received payload='{}'", payload);
        latch.countDown();
    }
}
