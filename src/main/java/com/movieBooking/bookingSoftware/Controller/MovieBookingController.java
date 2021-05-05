package com.movieBooking.bookingSoftware.Controller;

import com.movieBooking.bookingSoftware.Service.DBService;
import com.movieBooking.bookingSoftware.Service.PaymentService;
import com.movieBooking.bookingSoftware.TO.BookingDetailsTO;
import com.movieBooking.bookingSoftware.TO.PaymentDetailsTO;
import com.movieBooking.bookingSoftware.TO.UserDetailsTO;
import com.movieBooking.bookingSoftware.model.BookingDetailReq;
import com.movieBooking.bookingSoftware.model.MovieReq;
import com.movieBooking.bookingSoftware.model.PaymentReq;
import com.movieBooking.bookingSoftware.model.UserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/MovieApp")
public class MovieBookingController {
    @Autowired
    DBService dbService;

    @Autowired
    PaymentService paymentService;

    private HashMap<String,String>users=new HashMap<>();

    @PostMapping(value="/Save")
    public String saveDetails(@RequestBody MovieReq req){
        UserDetailsTO userDetails =new UserDetailsTO();
        userDetails.setName("karnan");
        userDetails.setId((req.getId()));
        return dbService.saveDetails(userDetails);

         }

         //This is for checking the maximum seats and multiple user checks
    @PostMapping(value="/CheckSeats")
    public boolean checkSeats(@RequestBody UserReq userReq){

        UserDetailsTO userDetails = new UserDetailsTO();
        userDetails.setId(userReq.getId());
        userDetails.setSeatNos(userReq.getSeatNos());
        userDetails.setTheatreId(userReq.getTheatreId());
        userDetails.setShowTime(userReq.getShowTime());
        userDetails.setTimeStamp(userReq.getTimeStamp());
        System.out.println("Checking seat availability");
        dbService.checkMaxSeats(userDetails);
        users=dbService.checkSameSeatBookForMultipleUsers(userDetails);
        //saveBookingDetails
        //   call the payment service
            //if paymentservice is success
            //{
                 //insert into Booking Details table;need to pass the bookingDetailsTO;
           // }
        return true;
    }

    //This gets called after the user selects the seats and proceed to payment
    @PostMapping(value="/Payment")
    public boolean payTickets(@RequestBody PaymentReq paymentReq)
    {
        PaymentDetailsTO paymentDetailsTO = new PaymentDetailsTO();
        paymentDetailsTO.setPaymentID(paymentReq.getPaymentID());
        paymentDetailsTO.setPaymentMethod(paymentReq.getPaymentMethod());
        paymentDetailsTO.setCardNumber(paymentReq.getCardNumber());
        if(paymentService.getPaymentStatus(paymentDetailsTO))
        {
            //set BookingDetailsTO
            //insert into payment details table
            //write files to create entity for payment and insert it
            //model.addattribute("payment",success);
            //The above will be called from the front-end and the url value will be passed by /saveBooking
            //call the saveBooking detail method by passing the url as /SaveBooking
            return true;
        }
        else
        return false;
    }

    //This gets called after payment successful getPaymentStatus returns success
    //Will be passing the /SaveBooking url to front-end.
    @PostMapping(value = "/SaveBooking")
    public String saveBookingDetails(@RequestBody BookingDetailReq bookingDetailReq)
    {
        BookingDetailsTO bookingDetailsTO = new BookingDetailsTO();
        bookingDetailsTO.setBookingId(users.get("Id")+users.get("ShowTime"));
        bookingDetailsTO.setUserId(users.get("Id"));
        System.out.println("UserId"+users.get("Id"));
        bookingDetailsTO.setSeatNo(users.get("SeatNos"));
        bookingDetailsTO.setShowTime(users.get("ShowTime"));
        bookingDetailsTO.setTheatreId(users.get("TheatreId"));
        dbService.saveBookingDetails(bookingDetailsTO);
        return dbService.saveBookingDetails(bookingDetailsTO);
    }
}