package com.ead.busbooking.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer seatNumber;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BusSchedule busSchedule;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Booking booking;

}