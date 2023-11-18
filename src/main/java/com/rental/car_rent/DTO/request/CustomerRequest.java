package com.rental.car_rent.DTO.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CustomerRequest {
    @NotBlank(message = "name required")
    private String name;

    @NotBlank(message = "address required")
    private String address;

    @NotBlank(message = "phoneNumber Required")
    private String phoneNumber;
}
