package com.movieBooking.bookingSoftware.Repository;


import com.movieBooking.bookingSoftware.Entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,String>{
    @Query("SELECT emp FROM MovieEntity emp where emp.id = :id")
    List<MovieEntity> fetchDetails(@Param("id") String id);

}
