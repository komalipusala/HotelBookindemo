package com.example.HotelBooking_demo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private String status; // Available / Occupied
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookingHistory> bookingHistories;
    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(this.status);
    }
}