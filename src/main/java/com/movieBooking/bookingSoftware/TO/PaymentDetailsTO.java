package com.movieBooking.bookingSoftware.TO;


import lombok.Getter;
import lombok.Setter;

public class PaymentDetailsTO {

    @Getter
    @Setter
    public String paymentID;

    @Getter
    @Setter
    public String transactionID;

    @Getter
    @Setter
    public String cardNumber;

    @Getter
    @Setter
    public String bankName;

    @Getter
    @Setter
    public String paymentMethod;
}
