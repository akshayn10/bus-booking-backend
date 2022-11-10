package com.ead.busbooking.service;

import com.ead.busbooking.dto.CustomerAuthResponse;
import com.ead.busbooking.dto.CustomerDto;
import com.ead.busbooking.dto.CustomerLoginDto;
import com.ead.busbooking.entity.Customer;
import com.ead.busbooking.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public CustomerDto addCustomer(Customer customer) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        customer.setPassword(encoder.encode(customer.getPassword()));

        if(customerRepository.existsByMobileNumber(customer.getMobileNumber())){
            throw new Exception("Mobile number already exist");
        }
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(savedCustomer.getId());
        customerDto.setName(savedCustomer.getName());
        customerDto.setMobileNumber(savedCustomer.getMobileNumber());
        return customerDto;
    }

    public CustomerAuthResponse loginCustomer(CustomerLoginDto dto) {
        CustomerAuthResponse customerAuthResponse = new CustomerAuthResponse();
        Customer customer = customerRepository.findByMobileNumber(dto.getMobileNumber());
        if(customer != null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(encoder.matches(dto.getPassword(), customer.getPassword())){
                customerAuthResponse.setIsAuthenticated(true);
                customerAuthResponse.setCustomerId(customer.getId());
                customerAuthResponse.setCustomerName(customer.getName());
                customerAuthResponse.setMessage("Login Successful");
                return customerAuthResponse;
            }
            customerAuthResponse.setIsAuthenticated(false);
            customerAuthResponse.setMessage("Password error");
            return customerAuthResponse;
        }
        customerAuthResponse.setIsAuthenticated(false);
        customerAuthResponse.setMessage("Login Failure");
        return customerAuthResponse;
    }
}
