package com.yamakishi.str_producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message).whenComplete(
                (result, throwable) -> {
                    if (throwable != null) {
                        // handle failure
                        log.info("Unable to send message=["
                                + message + "] due to : " + throwable.getMessage());
                    } else {
                        // handle success
                        log.info("Sent message=[" + message +
                                "] with offset=[" + result.getRecordMetadata().offset() + "]"+
                                "] with partition=[" + result.getRecordMetadata().partition() + "]"
                        );
                    }
                }
        );
    }
}
