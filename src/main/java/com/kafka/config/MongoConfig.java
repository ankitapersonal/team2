package com.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.kafka.repository.EventRepository;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

@Configuration
@EnableReactiveMongoRepositories("com.kafka.repository")
public class MongoConfig extends AbstractReactiveMongoConfiguration 
{
	@Value("${spring.data.mongodb.database}")
	private String databaseName;
	
	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;
	
	
	@Override
    protected String getDatabaseName() {
        return databaseName;
    }
	
	@Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }
	
	 @Bean
	 public ReactiveMongoTemplate reactiveMongoTemplate() 
	 {
		 return new ReactiveMongoTemplate(mongoClient(), getDatabaseName()) ;
	 }
	

    

}
