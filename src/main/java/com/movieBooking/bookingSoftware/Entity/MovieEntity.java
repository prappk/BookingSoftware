package com.movieBooking.bookingSoftware.Entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="MOVIE_DB")
@Data
public class MovieEntity {
    @Id
    @Column(name="ID")
    private String id;

    @Column(name="THEATRE_ID")
    private String theatreId;

    @Column(name="MOVIE_NAME")
    private String name;

    @Column(name="VENUE")
    private String venue;

    @Column(name="SCREEN_NAME")
    private String screenName;

    @Column(name="SHOW_TIME")
    private Date bookingDate;
}