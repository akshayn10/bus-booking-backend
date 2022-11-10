package com.ead.busbooking.repository;

import com.ead.busbooking.entity.Booking;
import com.ead.busbooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {


    List<Seat> findAllByBusScheduleId(Long id);

}
