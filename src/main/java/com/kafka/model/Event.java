package com.kafka.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.kafka.model.EventMessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Event")
public class Event {
	
	@Id
	private String id;
	
	@Field("event_message")
	private String eventMsg;
	
	@Field("created_on")
	private LocalDateTime createdOn;
	
	@Field("modified_on")
	private LocalDateTime modifiedOn;
	
	@Field("status")
	private String status;
}
