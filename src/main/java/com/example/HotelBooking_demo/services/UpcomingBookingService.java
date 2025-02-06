
package com.example.HotelBooking_demo.services;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import com.example.HotelBooking_demo.model.UpcomingBooking;
public class UpcomingBookingService {
    private List<UpcomingBooking> bookings;
    public UpcomingBookingService() {
        this.bookings = new ArrayList<>();
    }
    public void addBooking(UpcomingBooking booking) {
        bookings.add(booking);
    }
    public List<UpcomingBooking> getUpcomingBookings() {
        List<UpcomingBooking> upcomingBookings = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        for (UpcomingBooking booking : bookings) {
            if (booking.getStartDate().isAfter(currentDate)) {
                upcomingBookings.add(booking);
            }
        }
        return upcomingBookings;
    }
}