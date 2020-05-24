package com.kafka.consumer.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.entity.User;

@Service
public class ConsumerController {

	@KafkaListener(topics="Kafka_String", groupId = "group_id")
	public void ConsumeString(String msg) {
		System.out.println(msg);
	}

	@KafkaListener(topics = "Kafka_Object", groupId = "group_id",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }
}
