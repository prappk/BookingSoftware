package com.movieBooking.bookingSoftware.Entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="USER_DB")
@Data
public class UserEntity {
    @Id
    @Column(name="USER_ID")
    private String userId;

    @Column(name="MOBILE_NO")
    private String mobileNo;

    @Column(name="EMAIL_ID")
    private String emailId;
}
