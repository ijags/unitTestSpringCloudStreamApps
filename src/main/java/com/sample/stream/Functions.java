package com.sample.stream;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class Functions {
	
	private static final Logger log = LoggerFactory.getLogger(Functions.class);

    @Bean
    Function<String, String> upperCase() {
		return message -> {
			String toUpperCase = message.toUpperCase();
			log.info("Converting {} to uppercase {} ", message, toUpperCase );
			return toUpperCase;
		};
	}
    
    
    @Bean
    Function<String, String> reverse(){
    	return message -> {
    		String toReversed = new StringBuilder(message).reverse().toString();
    		log.info("Reversing {}: {}", message, toReversed);
    		return toReversed;
    	};
    }
}
