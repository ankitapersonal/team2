package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.service.EventService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EventConsumerHandler {

	@Value("${apache.kafka.topic}")
	private String[] topics;


	private final EventService customService;

	@KafkaListener(topics = { "test-topic" })
	public void listen(@Payload ConsumerRecord consumerRecord) 
	{
		try 
		{
			customService.saveCustomData( consumerRecord.value().toString()).subscribe();
		} 
		catch (JsonProcessingException e) 
		{
			System.out.println("Exception on parsing EventMessage :" + e.getMessage());
		}
	}
}
