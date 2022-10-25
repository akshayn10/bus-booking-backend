package com.ead.busbooking.repository;

import com.ead.busbooking.entity.Bus;
import com.ead.busbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
