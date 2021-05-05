package com.movieBooking.bookingSoftware.model;

import lombok.Data;

@Data
public class UserReq {

    private String name;
    private String id;
    private String seatNos;
    private String theatreId;
    private String timeStamp;
    private String showTime;
}
