package com.ead.busbooking.service;

import com.ead.busbooking.entity.Bus;
import com.ead.busbooking.entity.Seat;
import com.ead.busbooking.repository.BusRepository;
import com.ead.busbooking.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BusService {
    private final BusRepository busRepository;
    private final SeatRepository seatRepository;

    public List<Bus> getAllBuses(){
        return busRepository.findAll();
    }
    public Bus addBus(Bus bus){

        busRepository.save(bus);
        for (int i = 0; i < bus.getSeatCapacity(); i++) {
            Seat seat = new Seat();
            seat.setBus(bus);
            seatRepository.save(seat);

        }
        return bus;
    }
    public List<Seat> getAllSeats(){

        return seatRepository.findAll();
    }

}
