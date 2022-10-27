package com.ead.busbooking.service;

import com.ead.busbooking.dto.AdminLoginRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    public boolean isAdmin(AdminLoginRequestDto dto){
        return dto.getUserName().equals("admin") && dto.getPassword().equals("password");
    }
}
