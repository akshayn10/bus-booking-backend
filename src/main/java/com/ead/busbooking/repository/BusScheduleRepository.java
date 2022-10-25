package com.ead.busbooking.repository;

import com.ead.busbooking.entity.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
}
