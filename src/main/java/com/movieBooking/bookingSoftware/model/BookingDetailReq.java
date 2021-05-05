package com.movieBooking.bookingSoftware.model;

import lombok.Data;

@Data
public class BookingDetailReq {

    private String bookingId;
    private String seatNos;
    private String userId;
    private String paymentId;
    private String theatreId;

}
