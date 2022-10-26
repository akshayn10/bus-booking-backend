package com.ead.busbooking.service;

import com.ead.busbooking.entity.Booking;
import com.ead.busbooking.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
    public Booking addBooking(Booking booking){
        return bookingRepository.save(booking);
    }
}
