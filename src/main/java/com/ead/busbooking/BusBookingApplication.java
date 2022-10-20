package com.ead.busbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BusBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusBookingApplication.class, args);
        System.out.println("Hello Bus Booking!");
    }

}