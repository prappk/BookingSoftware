package com.movieBooking.bookingSoftware.Service;

import com.movieBooking.bookingSoftware.TO.PaymentDetailsTO;

public interface PaymentService
{
    boolean getPaymentStatus(PaymentDetailsTO paymentDetailsTo);

}