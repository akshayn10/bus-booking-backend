package com.ead.busbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Date is mandatory")
    private Date date;
    private String from;
    private String to;
    @NotNull(message = "Departure time is mandatory")
    private Date departureTime;
    @NotNull(message = "Arrival time is mandatory")
    private Date arrivalTime;
    @NotNull(message = "ticket price mandatory")
    private Double ticketPrice;
    @ManyToOne(fetch = LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "bus_id", referencedColumnName = "id")
    private Bus bus;
//    @OneToMany(fetch = LAZY)
//    private List<Booking> bookings;
}