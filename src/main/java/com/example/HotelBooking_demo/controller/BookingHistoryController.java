package com.example.HotelBooking_demo.controller;

import com.example.HotelBooking_demo.services.BookingHistoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/booking-history")
public class BookingHistoryController {

    private final BookingHistoryService bookingHistoryService;

    public BookingHistoryController() {
        this.bookingHistoryService = new BookingHistoryService();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBooking(@RequestParam String booking) {
        bookingHistoryService.addBooking(booking);
        return ResponseEntity.ok("Booking added successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<String>> getBookingHistory() {
        return ResponseEntity.ok(bookingHistoryService.getBookingHistory());
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearHistory() {
        bookingHistoryService.clearHistory();
        return ResponseEntity.ok("Booking history cleared successfully");
    }
}

