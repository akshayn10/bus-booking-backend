package com.ead.busbooking.controller;


import com.ead.busbooking.dto.CustomerAuthResponse;
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
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customer));
    }
    @PostMapping("/login")
    public ResponseEntity<CustomerAuthResponse> loginCustomer(HttpServletResponse response, @RequestBody CustomerLoginDto dto) {
        CustomerAuthResponse customerAuthResponse = customerService.isCustomer(dto);
        if(customerAuthResponse.getIsAuthenticated()) {
            response.addCookie(new Cookie("customerId", customerAuthResponse.getCustomerId().toString()));
            response.addCookie(new Cookie("customerName", customerAuthResponse.getCustomerName()));
            response.addCookie(new Cookie("isAuthenticated", customerAuthResponse.getIsAuthenticated().toString()));
            return ResponseEntity.status(200).body(customerAuthResponse);
        }
        return ResponseEntity.status(401).body(customerAuthResponse);
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logoutCustomer(HttpServletResponse response) {
        response.addCookie(new Cookie("customerId", null));
        response.addCookie(new Cookie("customerName", null));
        response.addCookie(new Cookie("isAuthenticated", null));
        return ResponseEntity.ok("Logout Successful");
    }
}
