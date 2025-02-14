package com.example.HotelBooking_demo.services;
import com.example.HotelBooking_demo.model.UpcomingBooking;
import com.example.HotelBooking_demo.repo.UpcomingBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
@Service
public class UpcomingBookingService {
    @Autowired
    private UpcomingBookingRepository upcomingBookingRepository;
    // :white_check_mark: Add a new upcoming booking
    public UpcomingBooking addBooking(UpcomingBooking booking) {
        return upcomingBookingRepository.save(booking);
    }
    // :white_check_mark: Get all upcoming bookings
    public List<UpcomingBooking> getAllUpcomingBookings() {
        return upcomingBookingRepository.findAll();
    }
    // :white_check_mark: Get only future bookings
    public List<UpcomingBooking> getFutureBookings() {
        return upcomingBookingRepository.findByStartDateAfter(LocalDate.now());
    }
}






