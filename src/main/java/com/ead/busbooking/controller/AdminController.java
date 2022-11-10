package com.ead.busbooking.controller;

import com.ead.busbooking.dto.AdminLoginRequestDto;
import com.ead.busbooking.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AdminController {
    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<String> adminLogin(@RequestBody AdminLoginRequestDto adminLoginRequestDto) {
        if(adminService.isAdmin(adminLoginRequestDto)) {

            return ResponseEntity.status(200).body("Login Successful");
        }
        return ResponseEntity.status(401).body("Login Failed");
    }
}
