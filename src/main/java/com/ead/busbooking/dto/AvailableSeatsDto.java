package com.ead.busbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableSeatsDto {
    private Long id;
    private Integer seatNumber;
}
