package com.sample.stream;

import java.util.UUID;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessageSuplier {
	
	private static final Logger log = LoggerFactory.getLogger(MessageSuplier.class);
	
    @Bean
    Supplier<String> stringSupplier(){
        return () -> {
        	log.info("Supplier message - Message with Id...");
        	return "Message with Id: " + UUID.randomUUID();
        };
    }


}
