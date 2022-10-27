package com.ead.busbooking.service;

import com.ead.busbooking.dto.AvailableSeatsDto;
import com.ead.busbooking.dto.CustomerAuthResponse;
import com.ead.busbooking.entity.Customer;
import com.ead.busbooking.entity.Seat;
import com.ead.busbooking.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    public List<AvailableSeatsDto> getAvailableSeatsForSchedule(Long id){

        return mapToAvailableSeatsDto(seatRepository.findAllByBusScheduleAndBookingIsNull(id));
    }

    private List<AvailableSeatsDto> mapToAvailableSeatsDto(List<Seat> seats){
        System.out.println(seats);
        return seats.stream().map(s -> {
            AvailableSeatsDto availableSeatsDto = new AvailableSeatsDto();
            availableSeatsDto.setId(s.getId());
            availableSeatsDto.setSeatNumber(s.getSeatNumber());
            return availableSeatsDto;
        }).collect(Collectors.toList());
    }

}
