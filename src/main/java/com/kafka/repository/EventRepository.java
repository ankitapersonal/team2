package com.kafka.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.kafka.model.Event;


@Repository
public interface EventRepository extends  ReactiveMongoRepository<Event, String>{


}
