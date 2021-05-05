package com.movieBooking.bookingSoftware.model;

import lombok.Data;

@Data

public class PaymentReq {

    private String paymentID;
    private String transactionID;
    private String cardNumber;
    private String bankName;
    private String paymentMethod;
}
