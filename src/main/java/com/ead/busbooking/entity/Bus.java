package com.ead.busbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busNumber;
    private Integer seatCapacity;
//    @OneToMany(fetch = LAZY)
//    private List<Seat> seats;
}
