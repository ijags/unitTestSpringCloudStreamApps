package com.sample.stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.Message;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
public class MessagePublisherTests {

    @Autowired
    OutputDestination outputDestination;

    @Autowired
    MessagePublisher messagePublisher;


    @Test
    public void publishedMessage_Received(){
    	
        messagePublisher.publishMessage("TestMessage");
        Message<byte[]> result = outputDestination.receive(100, "stringPublisher");
        
        System.out.println("Result: " + result);
        
        assertThat(result).isNotNull();
        assertThat(new String(result.getPayload())).isEqualTo("TestMessage");
    }

    @Test
    public void publishedMessage2_Received(){
    	
        messagePublisher.publishMessage("Another TestMessage");
        Message<byte[]> result = outputDestination.receive(100, "stringPublisher");
        
        System.out.println("Result: " + result);
        
        assertThat(result).isNotNull();
        assertThat(new String(result.getPayload())).isEqualTo("Another TestMessage");
    }
}
