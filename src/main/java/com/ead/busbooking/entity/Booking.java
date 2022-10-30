package com.ead.busbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

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
    private Date bookingTime;
    @ManyToOne(fetch = LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
