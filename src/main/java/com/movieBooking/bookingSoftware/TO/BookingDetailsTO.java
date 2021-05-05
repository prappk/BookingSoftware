package com.movieBooking.bookingSoftware.TO;


import lombok.Getter;
import lombok.Setter;

public class BookingDetailsTO {

    @Getter
    @Setter
    public String bookingId;

    @Getter
    @Setter
    public String transactionId;

    @Getter
    @Setter
    public String userId;

    @Getter
    @Setter
    public String seatNo;

    @Getter
    @Setter
    public String theatreId;

    @Getter
    @Setter
    public String showTime;
}
