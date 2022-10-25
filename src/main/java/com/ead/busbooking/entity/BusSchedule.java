package com.ead.busbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Date is mandatory")
    private Instant date;
    @NotBlank(message = "Departure time is mandatory")
    private Instant departureTime;
    @NotBlank(message = "Arrival time is mandatory")
    private Instant arrivalTime;
    @NotBlank(message = "ticket price mandatory")
    private Double ticketPrice;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    private Bus bus;
//    @OneToMany(fetch = LAZY)
//    private List<Booking> bookings;
}