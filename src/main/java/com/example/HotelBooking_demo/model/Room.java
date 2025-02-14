package com.example.HotelBooking_demo.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String roomNumber;
    @Column(nullable = false)
    private String floor;
    @Column(nullable = false)
    private String roomType; // Deluxe, Executive, Suite
    @Column(nullable = false)
    private String bedType; // Twin, Queen, King
    @Column(nullable = false)
    private Double tariff; // Price per night
    @Column(nullable = false)
    private Boolean isAvailable;
    @Column(nullable = false)  // Add status column
    private String status;
    @JsonManagedReference
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingHistory> bookingHistories;
}











