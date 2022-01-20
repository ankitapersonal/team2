package com.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.kafka.model.EventMessage;

@EnableKafka
@Configuration
public class EventConsumerConfig {
	
	@Value("${apache.kafka.bootstrap-servers}")
	private String bootstrapServer;

	@Value("${apache.kafka.topic}")
	private String[] topics;
	
	/*
	 * Consumer config method
	 */
	@Bean
	public  Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaConsumer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
		props.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);
		props.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, StringDeserializer.class);
		props.put(JsonDeserializer.KEY_DEFAULT_TYPE, String.class);
		props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, String.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		return props;
	}
	
	/*
	 * Creates consumer factory using consumerConfigs
	 */
	@Bean
	public ConsumerFactory<String, EventMessage> consumerFactory()
	{
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}
	
	/*
	 * KafkaListenerContainerFactory is primarily for building containers for kafkaListener annotated methods.
	 */
	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, EventMessage>> kafkaListenerContainerFactory()
	{
		ConcurrentKafkaListenerContainerFactory<String, EventMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.getContainerProperties().setPollTimeout(3000);
		return factory;
		
	}
	
}
