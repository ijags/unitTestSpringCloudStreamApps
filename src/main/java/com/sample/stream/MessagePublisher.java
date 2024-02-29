package com.sample.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

	private static final Logger log = LoggerFactory.getLogger(MessagePublisher.class);
	
    private final StreamBridge streamBridge;

    public MessagePublisher(StreamBridge streamBridge ){
        this.streamBridge = streamBridge;
    }

    //rest-endpoint
    public void publishMessage(String messageString){
        streamBridge.send("test-publisher", messageString);
        log.info("Publishing via streamBridge: " + messageString);
    }

}

