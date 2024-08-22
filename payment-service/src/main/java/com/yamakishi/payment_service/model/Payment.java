package com.yamakishi.payment_service.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Payment implements Serializable {
    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;
}
