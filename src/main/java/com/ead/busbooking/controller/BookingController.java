package com.ead.busbooking.controller;

import com.ead.busbooking.dto.BookingRequestDto;
import com.ead.busbooking.entity.Booking;
import com.ead.busbooking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> addBooking(@RequestBody BookingRequestDto bookingRequestDto){
        return ResponseEntity.ok(bookingService.addBooking(bookingRequestDto));
    }
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        return ResponseEntity.ok(bookingService.getAllBookings());
    }



}
