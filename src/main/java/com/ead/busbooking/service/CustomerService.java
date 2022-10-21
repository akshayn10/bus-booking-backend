package com.ead.busbooking.service;

import com.ead.busbooking.entity.Customer;
import com.ead.busbooking.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
