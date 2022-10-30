package com.ead.busbooking.service;

import com.ead.busbooking.dto.CustomerAuthResponse;
import com.ead.busbooking.dto.SeatsDto;
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

    public List<SeatsDto> getAvailableSeatsForSchedule(Long id){

        return mapToSeatsDto(seatRepository.findAllByBusScheduleId(id));
    }

    private List<SeatsDto> mapToSeatsDto(List<Seat> seats){
        return seats.stream().map(s -> {
            SeatsDto seatsDto = new SeatsDto();
            seatsDto.setId(s.getId());
            seatsDto.setSeatNumber(s.getSeatNumber());
            seatsDto.setIsAvailable(s.getBooking() == null);
            return seatsDto;
        }).collect(Collectors.toList());
    }
}
