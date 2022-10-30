package com.ead.busbooking.service;

import com.ead.busbooking.dto.BookingRequestDto;
import com.ead.busbooking.entity.Booking;
import com.ead.busbooking.entity.Seat;
import com.ead.busbooking.repository.BookingRepository;
import com.ead.busbooking.repository.BusScheduleRepository;
import com.ead.busbooking.repository.CustomerRepository;
import com.ead.busbooking.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BusScheduleRepository busScheduleRepository;
    private final CustomerRepository customerRepository;
    private final SeatRepository seatRepository;

    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }
    public Booking addBooking(BookingRequestDto dto){
        Booking booking = new Booking();
        booking.setBookingTime(new Date());
        booking.setCustomer(customerRepository.findById(dto.getCustomerId()).get());
        bookingRepository.save(booking);

        System.out.println(booking);

        //Don't use optional
        dto.getSeats().stream().map(s -> seatRepository.findById(s).orElse(null)).forEach(seat -> {
            seat.setBooking(booking);
            seatRepository.save(seat);
        });
        return booking;
    }
}
