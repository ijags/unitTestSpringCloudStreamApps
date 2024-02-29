package com.sample.stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.messaging.Message;
import org.springframework.boot.builder.SpringApplicationBuilder;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class MessagePublisherCustomConfigTest {

    @EnableAutoConfiguration
    public static class CustomConfiguration {
    	// Define custom beans and configuration here using @Bean
    }
    
    @Test
    public void customConfigTestPublisher() {
        try (ConfigurableApplicationContext context = new SpringApplicationBuilder (
                TestChannelBinderConfiguration.getCompleteConfiguration(
                		CustomConfiguration.class))
                .web(WebApplicationType.NONE)
                .run("--spring.jmx.enabled=false")) {
        	
            StreamBridge streamBridge = context.getBean(StreamBridge.class);
            MessagePublisher messagePublisher = new MessagePublisher(streamBridge);
            
            messagePublisher.publishMessage("test message");
            
            OutputDestination output = context.getBean(OutputDestination.class);
            Message<byte[]> result = output.receive(100, "stringPublisher");
            
            assertThat(result).isNotNull();
            assertThat(new String(result.getPayload())).isEqualTo("test message");

        }
    }
    
}
