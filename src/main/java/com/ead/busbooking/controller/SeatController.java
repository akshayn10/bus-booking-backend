package com.ead.busbooking.controller;
import com.ead.busbooking.dto.SeatsDto;
import com.ead.busbooking.entity.Seat;
import com.ead.busbooking.service.BusService;
import com.ead.busbooking.service.SeatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seat")
@AllArgsConstructor
public class SeatController {
    private final BusService busService;
    private final SeatService seatService;

    @GetMapping
    ResponseEntity<List<Seat>> getAllSeats(){
        return ResponseEntity.ok(busService.getAllSeats());
    }
    @GetMapping("/schedule/{id}")
    ResponseEntity<List<SeatsDto>> getAvailableSeatsForSchedule(@PathVariable Long id){
        return ResponseEntity.ok(seatService.getAvailableSeatsForSchedule(id));
    }
}
