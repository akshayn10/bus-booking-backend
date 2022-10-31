package com.ead.busbooking.controller;


import com.ead.busbooking.dto.CustomerAuthResponse;
import com.ead.busbooking.dto.CustomerDto;
import com.ead.busbooking.dto.CustomerLoginDto;
import com.ead.busbooking.entity.Customer;
import com.ead.busbooking.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody Customer customer) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customer));
    }
    @PostMapping("/login")
    public ResponseEntity<CustomerAuthResponse> loginCustomer(@RequestBody CustomerLoginDto dto) {
        CustomerAuthResponse customerAuthResponse = customerService.loginCustomer(dto);
        if(customerAuthResponse.getIsAuthenticated()) {
            return ResponseEntity.status(200).body(customerAuthResponse);
        }
        return ResponseEntity.status(401).body(customerAuthResponse);
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logoutCustomer(HttpServletResponse response) {
        return ResponseEntity.ok("Logout Successful");
    }
}
