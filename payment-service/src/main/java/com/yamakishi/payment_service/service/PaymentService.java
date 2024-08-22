package com.yamakishi.payment_service.service;

import com.yamakishi.payment_service.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
