package com.movieBooking.bookingSoftware.Entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="BOOKING_DETAILS_DB")
@Data
public class BookingDetailEntity {

    @Id
    @Column(name="BOOKING_ID")
    private String bookingId;

    @Column(name="TRANSACTION_ID")
    private String transactionId;

    @Column(name="USER_ID")
    private String userId;

    @Column(name="SEAT_NO")
    private String seatNo;

    @Column(name="SHOW_TIME")
    private String showTime;

    @Column(name="THEATRE_ID")
    private String theatreId;
}
