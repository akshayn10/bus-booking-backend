package com.ead.busbooking.service;

import com.ead.busbooking.dto.BookingRequestDto;
import com.ead.busbooking.dto.BookingResponseDto;
import com.ead.busbooking.entity.Booking;
import com.ead.busbooking.entity.Bus;
import com.ead.busbooking.entity.BusSchedule;
import com.ead.busbooking.entity.Seat;
import com.ead.busbooking.repository.BookingRepository;
import com.ead.busbooking.repository.BusScheduleRepository;
import com.ead.busbooking.repository.CustomerRepository;
import com.ead.busbooking.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public BookingResponseDto addBooking(BookingRequestDto dto){
        Booking booking = new Booking();
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        booking.setBookingTime(new Date());
        booking.setCustomer(customerRepository.findById(dto.getCustomerId()).get());
        bookingRepository.save(booking);

        //Don't use optional
        List<Integer> seatNumbers= new ArrayList<>();
        dto.getSeats().stream().map(s -> seatRepository.findById(s).orElse(null)).forEach(seat -> {
            seat.setBooking(booking);
            seatNumbers.add(seat.getSeatNumber());
            seatRepository.save(seat);
        });
        bookingResponseDto.setBookingTime(booking.getBookingTime().toString());
        bookingResponseDto.setSeats(seatNumbers);

        Optional<Seat> seat= seatRepository.findById(dto.getSeats().get(0));

        BusSchedule busSchedule = busScheduleRepository.findById(seat.get().getBusSchedule().getId()).get();
        Bus bus = busSchedule.getBus();
        bookingResponseDto.setBusNumber(bus.getBusNumber());
        bookingResponseDto.setCustomerName(booking.getCustomer().getName());
        bookingResponseDto.setId(booking.getId());
        return bookingResponseDto;
    }
}
