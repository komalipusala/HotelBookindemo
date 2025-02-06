package com.example.HotelBooking_demo.services;
import java.util.ArrayList;
import java.util.List;

public class BookingHistoryService {
    private List<String> bookingHistory;
    public BookingHistoryService() {
        this.bookingHistory = new ArrayList<>();
    }
    public void addBooking(String booking) {
        bookingHistory.add(booking);
    }
    public List<String> getBookingHistory() {
        return new ArrayList<>(bookingHistory);
    }
    public void clearHistory() {
        bookingHistory.clear();
    }
}

