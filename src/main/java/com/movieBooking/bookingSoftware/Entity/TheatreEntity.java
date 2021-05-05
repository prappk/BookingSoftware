package com.movieBooking.bookingSoftware.Entity;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="THEATRE_DB")
public class TheatreEntity {
    @Id
    @Column(name = "THEATRE_ID")
    private String theatreId;

    @Column(name = "SEAT_NO", length = 3)//Eg A12,B45 alphanumeric with length as 3
    private String seatNo;

    @Column(name = "TIME_STAMP")
    private Date timeStamp;

    @Column(name = "IS_AVAILABLE")
    private boolean isAvailable;
}