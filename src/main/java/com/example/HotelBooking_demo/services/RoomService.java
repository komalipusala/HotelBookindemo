package com.example.HotelBooking_demo.services;
import com.example.HotelBooking_demo.model.Room;
import com.example.HotelBooking_demo.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    // :white_check_mark: Get all rooms from DB
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    // :white_check_mark: Get a room by ID
    public Room getRoomById(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        return room.orElse(null);
    }
    // :white_check_mark: Create a new room
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }
    // :white_check_mark: Update room details
    public Room updateRoom(Long id, Room updatedRoom) {
        if (roomRepository.existsById(id)) {
            updatedRoom.setId(id);
            return roomRepository.save(updatedRoom);
        }
        return null;
    }
    // :white_check_mark: Delete a room by ID
    public boolean deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }
    // :white_check_mark: Get rooms by type
    public List<Room> listRoomsByType(String type) {
        return roomRepository.findByRoomTypeIgnoreCase(type);
    }
    // :white_check_mark: Get available rooms by type and bed type
    public List<Room> listAvailableRooms(String type, String bedType) {
        return roomRepository.findByRoomTypeIgnoreCaseAndBedTypeIgnoreCaseAndIsAvailableTrue(type, bedType);
    }
}









