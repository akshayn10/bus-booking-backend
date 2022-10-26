package com.ead.busbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusScheduleRequestDto {
    private String date;
    private String departureTime;
    private String arrivalTime;
    private Double ticketPrice;
    private Long busId;
}
