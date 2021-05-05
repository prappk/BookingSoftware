package com.movieBooking.bookingSoftware.ServiceImpl;

import com.movieBooking.bookingSoftware.Entity.BookingDetailEntity;
import com.movieBooking.bookingSoftware.Entity.MovieEntity;
import com.movieBooking.bookingSoftware.Repository.BookingDetailRepository;
import com.movieBooking.bookingSoftware.Repository.MovieRepository;
import com.movieBooking.bookingSoftware.Service.DBService;
import com.movieBooking.bookingSoftware.Service.PaymentService;
import com.movieBooking.bookingSoftware.TO.BookingDetailsTO;
import com.movieBooking.bookingSoftware.TO.UserDetailsTO;
import com.movieBooking.bookingSoftware.TO.PaymentDetailsTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DBServiceImpl extends Thread implements DBService  {

    private final int MAX_SEATS=6;
    private boolean block =false;

    private String timeStamp;
    private String userSeatNos;
    private String theatreId;
    private String showTime;

    @Autowired
    PaymentService paymentService;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    BookingDetailRepository bookingDetailRepository;

    Logger logger= LoggerFactory.getLogger(DBServiceImpl.class);

    @Override
    public String saveDetails(UserDetailsTO userDetails) {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setId(userDetails.getId());
        movieEntity.setName(userDetails.getName());
        System.out.println("User id is::"+userDetails.getId()+userDetails.getName());
        movieRepository.save(movieEntity);
        List<MovieEntity> records=movieRepository.fetchDetails(userDetails.id.toString());
        if(records.size()>0){
            System.out.println("Records is present::"+records.toString());
        }
        return records.toString();
    }


    @Override
    public String saveBookingDetails(BookingDetailsTO bookingDetails)
    {
        BookingDetailEntity bookingDetailEntity = new BookingDetailEntity();
        bookingDetailEntity.setBookingId(bookingDetails.getBookingId());
        bookingDetailEntity.setSeatNo(bookingDetails.getSeatNo());
        bookingDetailEntity.setUserId(bookingDetails.getUserId());
        bookingDetailEntity.setSeatNo(bookingDetails.getSeatNo());
        bookingDetailEntity.setTheatreId(bookingDetails.getTheatreId());
        bookingDetailEntity.setShowTime(bookingDetails.getShowTime());
        System.out.println("Inserting Booking Details");
       // bookingDetailRepository.saveAll().save(bookingDetailEntity)
                bookingDetailRepository.saveAndFlush(bookingDetailEntity);
        return "DONE";
    }

    public String checkSeats(UserDetailsTO userDetailsTo)
    {
        checkMaxSeats(userDetailsTo);
        checkSameSeatBookForMultipleUsers(userDetailsTo);

        return "OK";
    }

    public String checkMaxSeats(UserDetailsTO userDetailTO)
    {
        userSeatNos=userDetailTO.getSeatNos();
        theatreId = userDetailTO.getTheatreId();
        showTime = userDetailTO.getShowTime();
        System.out.println("Checking Maximum Seats");
        String[] seatNo=userDetailTO.getSeatNos().split("@");
        if(seatNo.length>MAX_SEATS-1)
            return("Only maximum of six seats allowed to book");
        return("No Of booked seats less than six");
    }

    public HashMap checkSameSeatBookForMultipleUsers(UserDetailsTO userDetailTO)
    {
        HashMap<String,String>userRecord=new HashMap<>();
            //paymentService.getPaymentStatus(paymentDetailsTo);
        System.out.println("Checking Same Seat Booking");
        String bookingRecord=new String();
        Runnable runnable = () -> {
            try {
                synchronized (this)
                {
                    String name = Thread.currentThread().getName();
                    System.out.println("Current Thread is" + name);
                    if(userDetailTO.theatreId.equals(theatreId) &&  userDetailTO.getShowTime().equals(showTime) &&
                            (userDetailTO.getSeatNos().contains(userSeatNos)))
                    {
                        if ((userDetailTO.getSeatNos().length() > userSeatNos.length()))
                        {
                            userSeatNos = userDetailTO.getSeatNos();
                        }
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        };
        Thread t1= new Thread(runnable);
        t1.start();
        userRecord.put("Id",userDetailTO.getId());
        userRecord.put("SeatNos",userDetailTO.getSeatNos());
        userRecord.put("TimeStamp",userDetailTO.getTimeStamp());
        userRecord.put("ShowTime",userDetailTO.getShowTime());
        userRecord.put("TheatreId",userDetailTO.getTheatreId());
        return userRecord;
}
}