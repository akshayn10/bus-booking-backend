package com.ead.busbooking.service;

import com.ead.busbooking.dto.BusDto;
import com.ead.busbooking.entity.Bus;
import com.ead.busbooking.entity.Seat;
import com.ead.busbooking.repository.BusRepository;
import com.ead.busbooking.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        return bus;
    }
    public List<Seat> getAllSeats(){

        return seatRepository.findAll();
    }
    public void deleteBus(Long id){
        busRepository.deleteById(id);
    }
    public List<BusDto> getAllBusesDto(){
        return busToBusDto(busRepository.findAll());
    }

    private List<BusDto> busToBusDto(List<Bus> buses){
        return buses.stream().map(b -> {
            BusDto busDto = new BusDto();
            busDto.setId(b.getId());
            busDto.setBusNumber(b.getBusNumber());

            return busDto;
        }).collect(Collectors.toList());
    }

}
