package com.rental.car_rent.DTO.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateCustomerRequest {

    private String customer_id;
    private String name;
    private String address;
    private String phoneNumber;

}
