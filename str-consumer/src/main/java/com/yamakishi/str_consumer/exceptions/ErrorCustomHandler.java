package com.yamakishi.str_consumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.info("EXCEPTION HANDLER ::: ERROR {}", exception.getMessage());
        log.info("Payload ::: ERROR {}", message.getPayload());
        log.info("Headers ::: ERROR {}", message.getHeaders());
        log.info("Offset ::: ERROR {}", message.getHeaders().get("kafka_offset"));
        return null;
    }
}
