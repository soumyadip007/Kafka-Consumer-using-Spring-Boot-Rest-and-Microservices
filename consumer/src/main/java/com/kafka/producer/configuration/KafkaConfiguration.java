package com.kafka.producer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kafka.producer.entity.User;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	//-----------------------String-Object-----------------------
	
	@Bean
	public ProducerFactory<String, User> consumerFactory(){
		
		Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "Kafka_Object");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        
        return new DefaultKafkaProducerFactory<>(config);
    }
	
	
	@Bean
    public KafkaTemplate<String, User> kafkaTemplate() {
        return new KafkaTemplate<>(consumerFactory());
    }
	
	//-----------------------String-String-----------------------
	
	@Bean
	public ProducerFactory<String, String> producerFactory1(){
		
		Map<String, Object> config = new HashMap<>();



        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "Kafka_Object");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        
        return new DefaultKafkaProducerFactory<>(config);
    }
	

	@Bean
    public KafkaTemplate<String, String> kafkaTemplate1() {
        return new KafkaTemplate<>(producerFactory1());
    }
}
