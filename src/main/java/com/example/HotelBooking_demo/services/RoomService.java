package com.example.HotelBooking_demo.services;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.HotelBooking_demo.model.Room;
@Service
public class RoomService {
    private List<Room> rooms = new ArrayList<>();
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }
    public Room getRoomById(int id) {
        return rooms.stream()
                .filter(room -> room.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public Room createRoom(Room room) {
        rooms.add(room);
        return room;
    }
    public Room updateRoom(Long id, Room updatedRoom) {
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.getId().equals(id)) {
                rooms.set(i, updatedRoom);
                return updatedRoom;
            }
        }
        return null;
    }
    public boolean deleteRoom(Long id) {
        return rooms.removeIf(room -> room.getId().equals(id));
    }
    public List<Room> listRoomsByType(String type) {
        return rooms.stream()
                .filter(room -> room.getRoomType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }
    public List<Room> listAvailableRooms(String type, String bedType) {
        return rooms.stream()
                .filter(room -> room.getRoomType().equalsIgnoreCase(type) &&
                                room.getBedType().equalsIgnoreCase(bedType) &&
                                room.isAvailable())
                .collect(Collectors.toList());
    }
}
