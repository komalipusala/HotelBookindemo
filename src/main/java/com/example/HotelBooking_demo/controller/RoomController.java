package com.example.HotelBooking_demo.controller;
import com.example.HotelBooking_demo.model.Room;
import com.example.HotelBooking_demo.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;
    // :white_check_mark: Get all rooms
    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }
    // :white_check_mark: Get room by ID
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        return (room !=null) ? ResponseEntity.ok(room) : ResponseEntity.notFound().build();
    }
    // :white_check_mark: Create a new room
    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room savedRoom = roomService.createRoom(room);
        return ResponseEntity.ok(savedRoom);
    }
    // :white_check_mark: Update a room
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room roomDetails) {
        Room updatedRoom = roomService.updateRoom(id, roomDetails);
        return (updatedRoom != null) ? ResponseEntity.ok(updatedRoom) : ResponseEntity.notFound().build();
    }
    // :white_check_mark: Delete a room
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        boolean isDeleted = roomService.deleteRoom(id);
        return (isDeleted) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    // :white_check_mark: Get rooms by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Room>> listRoomsByType(@PathVariable String type) {
        List<Room> rooms = roomService.listRoomsByType(type);
        return ResponseEntity.ok(rooms);
    }
    // :white_check_mark: Get available rooms by type and bed type
    @GetMapping("/available")
    public ResponseEntity<List<Room>> listAvailableRooms(@RequestParam String type, @RequestParam String bedType) {
        List<Room> availableRooms = roomService.listAvailableRooms(type, bedType);
        return ResponseEntity.ok(availableRooms);
    }
}






