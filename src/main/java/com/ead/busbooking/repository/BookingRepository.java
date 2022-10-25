package com.ead.busbooking.repository;

import com.ead.busbooking.entity.Booking;
import com.ead.busbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
