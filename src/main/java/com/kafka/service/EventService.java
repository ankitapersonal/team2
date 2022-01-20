package com.kafka.service;

import java.time.LocalDateTime;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.github.underscore.lodash.U;
import com.kafka.model.Event;
import com.kafka.repository.EventRepository;
import com.kafka.util.Constants;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class EventService {

	
	private final EventRepository eventRepository;
	
	private final ObjectMapper objectMapper;

	public Mono<Event> saveCustomData( String data) throws JsonProcessingException
	{
		System.out.println("service method called for saving  data: " + data);
		//String xml = U.jsonToXml(objectMapper.writeValueAsString(data));
		JSONObject json = new JSONObject(data);
		String xml = XML.toString(json);
		System.out.println("Converted to xml: " + xml);

		Event event = Event.builder()
				.eventMsg(xml)
				.createdOn(LocalDateTime.now())
				.status(Constants.STATUS_OPEN)
				.build();
		return eventRepository.save(event);

	}

}
