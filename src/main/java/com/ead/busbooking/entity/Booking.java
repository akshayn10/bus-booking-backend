package com.ead.busbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Instant bookingTime;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private BusSchedule busSchedule;
}
