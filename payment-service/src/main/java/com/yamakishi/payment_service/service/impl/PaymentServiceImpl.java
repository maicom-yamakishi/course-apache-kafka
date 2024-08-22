package com.yamakishi.payment_service.service.impl;

import com.yamakishi.payment_service.model.Payment;
import com.yamakishi.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;
    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("PAYMENT SERVICE {}", payment);
        Thread.sleep(2000);
        log.info("Sending payment..");
        kafkaTemplate.send("payment-topic" ,payment);

    }
}
