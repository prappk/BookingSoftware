package com.movieBooking.bookingSoftware.TO;

import lombok.Getter;
import lombok.Setter;

public class UserDetailsTO {

    @Getter
    @Setter
    public String name;

    @Getter
    @Setter
    public String id;

    @Getter
    @Setter
    public String seatNos;

    @Getter
    @Setter
    public String theatreId;

    @Getter
    @Setter
    public String showTime;

    @Getter
    @Setter
    public String timeStamp;
}
