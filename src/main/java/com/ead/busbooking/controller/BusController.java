package com.ead.busbooking.controller;

import com.ead.busbooking.entity.Bus;
import com.ead.busbooking.entity.Customer;
import com.ead.busbooking.service.BusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
@AllArgsConstructor
public class BusController {
    private final BusService busService;

    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses(){
        return ResponseEntity.ok(busService.getAllBuses());
    }
    @PostMapping
    public ResponseEntity<Bus> addCustomer(@RequestBody Bus bus){
        return ResponseEntity.status(HttpStatus.CREATED).body(busService.addBus(bus));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id){
        busService.deleteBus(id);
        return ResponseEntity.noContent().build();
    }
}
