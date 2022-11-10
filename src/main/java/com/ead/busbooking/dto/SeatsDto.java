package com.ead.busbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatsDto {
    private Long id;
    private Integer seatNumber;
    private Boolean isAvailable;
}
