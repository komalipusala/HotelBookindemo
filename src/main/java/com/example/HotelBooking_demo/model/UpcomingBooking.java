package com.example.HotelBooking_demo.model;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "upcoming_bookings")
public class UpcomingBooking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "room_type", nullable = false)
    private String roomType;
    @Column(name = "bed_type", nullable = false)
    private String bedType;
    @Column(name = "number_of_rooms", nullable = false)
    private int numberOfRooms;
}