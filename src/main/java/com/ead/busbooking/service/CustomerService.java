package com.ead.busbooking.service;

import com.ead.busbooking.dto.CustomerAuthResponse;
import com.ead.busbooking.dto.CustomerLoginDto;
import com.ead.busbooking.entity.Customer;
import com.ead.busbooking.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer addCustomer(Customer customer) throws Exception {
        if(customerRepository.existsByMobileNumber(customer.getMobileNumber())){
            throw new Exception("Mobile number already exist");
        }
        return customerRepository.save(customer);
    }

    public CustomerAuthResponse isCustomer(CustomerLoginDto dto) {
        CustomerAuthResponse customerAuthResponse = new CustomerAuthResponse();
        Customer customer = customerRepository.findByMobileNumber(dto.getMobileNumber());
        if(customer != null){
            customerAuthResponse.setCustomerId(customer.getId());
            customerAuthResponse.setCustomerName(customer.getName());
            customerAuthResponse.setIsAuthenticated(true);
            customerAuthResponse.setMessage("Login Successful");
            return customerAuthResponse;
        }
        customerAuthResponse.setIsAuthenticated(false);
        customerAuthResponse.setMessage("Login Failure");
        return customerAuthResponse;
    }
}
