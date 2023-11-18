package com.rental.car_rent.DTO.response;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CustomerResponse {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
}
