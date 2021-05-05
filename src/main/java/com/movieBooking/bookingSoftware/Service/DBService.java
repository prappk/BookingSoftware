package com.movieBooking.bookingSoftware.Service;


import com.movieBooking.bookingSoftware.TO.BookingDetailsTO;
import com.movieBooking.bookingSoftware.TO.UserDetailsTO;

import java.util.HashMap;

public interface DBService {
    String saveDetails(UserDetailsTO userDetails);
    String saveBookingDetails(BookingDetailsTO bookingDetails);
    String checkMaxSeats(UserDetailsTO userDetails);
    HashMap checkSameSeatBookForMultipleUsers(UserDetailsTO userDetails);
}
