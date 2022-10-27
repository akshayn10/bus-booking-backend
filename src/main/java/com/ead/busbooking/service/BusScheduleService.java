package com.ead.busbooking.service;

import com.ead.busbooking.dto.BusScheduleRequestDto;
import com.ead.busbooking.entity.Bus;
import com.ead.busbooking.entity.BusSchedule;
import com.ead.busbooking.entity.Seat;
import com.ead.busbooking.repository.BusRepository;
import com.ead.busbooking.repository.BusScheduleRepository;
import com.ead.busbooking.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BusScheduleService {
    private final BusScheduleRepository busScheduleRepository;
    private final DateConverterService dateConverterService;
    private final SeatRepository seatRepository;
    private final BusRepository busRepository;

    public List<BusSchedule> getAllBusSchedules(){
        return busScheduleRepository.findAll();
    }
    public BusSchedule addBusSchedule(BusScheduleRequestDto busScheduleRequestDto){
        BusSchedule busSchedule = new BusSchedule();
        Optional<Bus> bus = busRepository.findById(busScheduleRequestDto.getBusId());
        busSchedule.setBus(bus.get());
        busSchedule.setDepartureTime(dateConverterService.convertFromStringToDate(busScheduleRequestDto.getDepartureTime()));
        busSchedule.setArrivalTime(dateConverterService.convertFromStringToDate(busScheduleRequestDto.getArrivalTime()));
        busSchedule.setDate(dateConverterService.convertFromStringToDate(busScheduleRequestDto.getDate()));
        busSchedule.setTicketPrice(busScheduleRequestDto.getTicketPrice());
        busScheduleRepository.save(busSchedule);

        //Create Seats
        int seatCount = bus.get().getSeatCapacity();

        for (int i = 0; i < seatCount; i++) {
            Seat seat = new Seat();
            seat.setSeatNumber(i+1);
            seat.setBusSchedule(busSchedule);

            seatRepository.save(seat);
        }
        return busSchedule;
    }
}
