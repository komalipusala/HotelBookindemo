package com.example.HotelBooking_demo.controller;
import com.example.HotelBooking_demo.upcomingbookingDTO.UpcomingBookingRequestDTO;
import com.example.HotelBooking_demo.upcomingbookingDTO.UpcomingBookingResponseDTO;
import com.example.HotelBooking_demo.services.UpcomingBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController

@RequestMapping("/upcoming-bookings")
public class UpcomingBookingController {
    private final UpcomingBookingService upcomingBookingService;
    public UpcomingBookingController(UpcomingBookingService upcomingBookingService) {
        this.upcomingBookingService = upcomingBookingService;
    }
    // Create a new booking
    @PostMapping
    public ResponseEntity<UpcomingBookingResponseDTO> createBooking(@RequestBody UpcomingBookingRequestDTO requestDTO) {
        UpcomingBookingResponseDTO responseDTO = upcomingBookingService.createBooking(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
    // Get all bookings
    @GetMapping
    public ResponseEntity<List<UpcomingBookingResponseDTO>> getAllBookings() {
        List<UpcomingBookingResponseDTO> bookings = upcomingBookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
    // Get a booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<UpcomingBookingResponseDTO> getBookingById(@PathVariable Long id) {
        UpcomingBookingResponseDTO responseDTO = upcomingBookingService.getBookingById(id);
        return ResponseEntity.ok(responseDTO);
    }
    // Delete a booking by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        upcomingBookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}






