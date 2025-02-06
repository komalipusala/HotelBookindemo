package com.example.HotelBooking_demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HotelBooking_demo.model.BookingHistory;
import org.springframework.stereotype.Repository;
@Repository
public interface BookingHistoryRepo extends JpaRepository<BookingHistory, Long> {
}
