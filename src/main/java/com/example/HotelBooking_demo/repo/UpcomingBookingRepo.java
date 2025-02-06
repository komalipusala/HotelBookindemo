package com.example.HotelBooking_demo.repo;
import com.example.HotelBooking_demo.model.UpcomingBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UpcomingBookingRepo extends JpaRepository<UpcomingBooking, Long> {
}