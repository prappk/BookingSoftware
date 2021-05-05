# BookingSoftware

This is application for movie reservation

The flow of the application is as below

controller(TO)-->Service-->Repository(Entity)-->Model.

Written only the back -end logic for service endpoints.Need to pass the request parameters through front-end for user details,payment details.

This application can be tested through postman. If you don't have postman,please download from https://www.postman.com › downloads

The following are the database tables 

USER_DB(MANUALLY CREATED)
userid(primary key) name age emailid mobnumber

THEATRE_DB(MANUALLY CREATED)
theatre_id is_available seat_no time_stamp

booking_details_db(created through endpoints)
booking_id seat_no show_time theatre_id transaction_id user_id

However more fields can be added,I just added the key fields useful for identifying the booking details.

The endpoints are 

1./MovieApp/CheckSeats

The following url needs to be given in postman after running the application
http://localhost:7001/MovieApp/CheckSeats
For checking the logic for maximum seats and same seats booking for multiple users


2./MovieApp/SaveBooking

http://localhost:7001/MovieApp/SaveBooking
For saving the user details we need to give the following json format while testing in postman
{ "name": "pradeep1", "id":"userid1", "seatNos":"B12#B13#B14", "theatreId":"Theatreid2", "timeStamp":"05042021", "showTime":"134505052021" }
This gets called after the payment is successful.
This one also coded only the end-point.

3./MovieApp/Payment 

For checking the payment timeout and response from payment webservice.
Defined only the end point ,this gets checked when the user gives the details of the payment details like bank,cardnumber,mode of booking from the front-end.
The appropriate url gets mapped and it will be called from here.
When this is success booking details,would be inserted into booking_details_db.
