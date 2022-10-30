package com.ead.busbooking.repository;

import com.ead.busbooking.entity.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
    List<BusSchedule> findAllByBusId(Long id);
}
