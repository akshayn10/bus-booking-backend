package com.ead.busbooking.service;

import com.ead.busbooking.dto.BusScheduleRequestDto;
import com.ead.busbooking.entity.Bus;
import com.ead.busbooking.entity.BusSchedule;
import com.ead.busbooking.repository.BusRepository;
import com.ead.busbooking.repository.BusScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BusScheduleService {
    private final BusScheduleRepository busScheduleRepository;
    private final DateConverterService dateConverterService;
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
        return busScheduleRepository.save(busSchedule);
    }
}
