package com.example.HotelBooking_demo.controller;

import com.example.HotelBooking_demo.model.UpcomingBooking;
import com.example.HotelBooking_demo.services.UpcomingBookingService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/upcoming-bookings")
public class UpcomingBookingController {

    private final UpcomingBookingService upcomingBookingService;

    public UpcomingBookingController() {
        this.upcomingBookingService = new UpcomingBookingService();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBooking(@RequestBody UpcomingBooking booking) {
        upcomingBookingService.addBooking(booking);
        return ResponseEntity.ok("Upcoming booking added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<UpcomingBooking>> getUpcomingBookings() {
        return ResponseEntity.ok(upcomingBookingService.getUpcomingBookings());
    }
}

