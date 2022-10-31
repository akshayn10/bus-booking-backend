package com.ead.busbooking.controller;

import com.ead.busbooking.dto.BusScheduleDto;
import com.ead.busbooking.dto.BusScheduleRequestDto;
import com.ead.busbooking.dto.ScheduleSearchRequestDto;
import com.ead.busbooking.entity.Bus;
import com.ead.busbooking.entity.BusSchedule;
import com.ead.busbooking.service.BusScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class BusScheduleController {
    private final BusScheduleService busScheduleService;

    @GetMapping
    public ResponseEntity<List<BusSchedule>> getAllBusSchedules(){
        return ResponseEntity.ok(busScheduleService.getAllBusSchedules());
    }
    @PostMapping
    public ResponseEntity<BusSchedule> addBusSchedule(@RequestBody BusScheduleRequestDto busScheduleRequestDto) throws ParseException {
        return ResponseEntity.status(HttpStatus.CREATED).body(busScheduleService.addBusSchedule(busScheduleRequestDto));
    }
    @GetMapping("/bus/{id}")
    public ResponseEntity<List<BusScheduleDto>> getBusScheduleByBusId(@PathVariable Long id){
        return ResponseEntity.ok(busScheduleService.getBusScheduleByBusId(id));
    }
    @PostMapping("/search")
    public ResponseEntity<List<BusScheduleDto>> searchBusSchedule(@RequestBody ScheduleSearchRequestDto scheduleSearchRequestDto) throws ParseException {
        return ResponseEntity.ok(busScheduleService.searchBusSchedule(scheduleSearchRequestDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBusSchedule(@PathVariable Long id){
        busScheduleService.deleteBusSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
