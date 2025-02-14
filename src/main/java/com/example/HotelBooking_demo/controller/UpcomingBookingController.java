package com.example.HotelBooking_demo.controller;
import com.example.HotelBooking_demo.model.UpcomingBooking;
import com.example.HotelBooking_demo.services.UpcomingBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/upcoming-bookings")
public class UpcomingBookingController {
    @Autowired
    private UpcomingBookingService upcomingBookingService;
    // :white_check_mark: Add a new upcoming booking
    @PostMapping
    public ResponseEntity<UpcomingBooking> addBooking(@RequestBody UpcomingBooking booking) {
        UpcomingBooking savedBooking = upcomingBookingService.addBooking(booking);
        return ResponseEntity.ok(savedBooking);
    }
    // :white_check_mark: Get all upcoming bookings
    @GetMapping
    public ResponseEntity<List<UpcomingBooking>> getAllBookings() {
        return ResponseEntity.ok(upcomingBookingService.getAllUpcomingBookings());
    }
    // :white_check_mark: Get only future bookings
    @GetMapping("/future")
    public ResponseEntity<List<UpcomingBooking>> getFutureBookings() {
        return ResponseEntity.ok(upcomingBookingService.getFutureBookings());
    }
}






