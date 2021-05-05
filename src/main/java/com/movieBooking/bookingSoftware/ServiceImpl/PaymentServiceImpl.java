package com.movieBooking.bookingSoftware.ServiceImpl;

import com.movieBooking.bookingSoftware.Service.PaymentService;
import com.movieBooking.bookingSoftware.TO.PaymentDetailsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;

@Service
public class PaymentServiceImpl implements PaymentService {

    private long WAIT_SECONDS = 10;

    @Override
    public boolean getPaymentStatus(PaymentDetailsTO paymentDetailsTo)
    {
        if(checkPaymentDuration(paymentDetailsTo))
        {
          //  if response is success from the payment webservice call
                return true;
        }
        else
            return false;
    }

    public boolean checkPaymentDuration(PaymentDetailsTO paymentDetailsTo)
    {
        final long end = System.currentTimeMillis() + (WAIT_SECONDS * 1000);
        String paymentServiceResponse="SUCCESS";
        while(System.currentTimeMillis() < end)
        {
            //call the payment service url by passing the paymentDetailsTO
            //if the webservice returns success then return true
            System.out.println("Time now is"+System.currentTimeMillis());
        }
        System.out.println("Over");
        return false;
    }
}
