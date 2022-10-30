package com.ead.busbooking.repository;

import com.ead.busbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByMobileNumber(String mobileNumber);
    Customer findByMobileNumber(String mobileNumber);
}
