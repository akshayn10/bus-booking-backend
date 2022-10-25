package com.ead.busbooking.repository;

import com.ead.busbooking.entity.Customer;
import com.ead.busbooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
