package com.yamakishi.payment_consumer.listener;

import com.yamakishi.payment_consumer.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
@Log4j2
@RequiredArgsConstructor
@Component
public class JsonListener {
    @SneakyThrows
    @KafkaListener(groupId = "create-group", topics = "payment-topic",
            containerFactory = "paymentContainerFactory")
    public void antiFraud(@Payload Payment payment){
        log.info("Payment {}", payment);
        Thread.sleep(2000);
        log.info("Validate Fraud...");
        Thread.sleep(2000);
        log.info("Approved...");
    }

    @SneakyThrows
    @KafkaListener(groupId = "pdf-group", topics = "payment-topic",
            containerFactory = "paymentContainerFactory")
    public void pdfGenerator(){
        Thread.sleep(3000);
        log.info("Generating PDF...");
    }

    @SneakyThrows
    @KafkaListener(groupId = "email-group", topics = "payment-topic",
            containerFactory = "paymentContainerFactory")
    public void sendEmail
            (){
        Thread.sleep(4000);
        log.info("Sending EMAIL...");
    }
}
