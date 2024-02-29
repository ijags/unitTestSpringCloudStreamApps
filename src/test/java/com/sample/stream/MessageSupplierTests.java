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
public class MessageSupplierTests {

    @Autowired
    OutputDestination outputDestination;

    @Test
    public void publishedMessage_WillBe_Received(){
        Message<byte[]> result = outputDestination.receive(100, "test-destination");
        assertThat(result).isNotNull();
        assertThat(new String(result.getPayload())).contains("Message with Id");

        result = outputDestination.receive(1100, "test-destination");
        assertThat(result).isNotNull();
        assertThat(new String(result.getPayload())).contains("Message with Id");
        
        result = outputDestination.receive(2100, "test-destination");
        assertThat(result).isNotNull();
        assertThat(new String(result.getPayload())).contains("Message with Id");

    }

}
