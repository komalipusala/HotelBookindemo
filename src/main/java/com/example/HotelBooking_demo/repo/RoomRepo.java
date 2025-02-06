package com.example.HotelBooking_demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HotelBooking_demo.model.Room;
import org.springframework.stereotype.Repository;
@Repository
public interface RoomRepo extends JpaRepository<Room, Long> {
}