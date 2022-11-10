package com.ead.busbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Customer name is mandatory")
    private String name;
    @NotBlank(message = "Customer mobile number is mandatory")
    private String mobileNumber;
    @NotBlank(message = "Password is mandatory")
    private String password;
}
