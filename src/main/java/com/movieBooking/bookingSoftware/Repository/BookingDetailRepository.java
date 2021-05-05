package com.movieBooking.bookingSoftware.Repository;


import com.movieBooking.bookingSoftware.Entity.BookingDetailEntity;
import com.movieBooking.bookingSoftware.Entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetailEntity,String> {

}
