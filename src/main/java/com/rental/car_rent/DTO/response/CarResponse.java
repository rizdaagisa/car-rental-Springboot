package com.rental.car_rent.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarResponse {
    private String name;

    private String model;

    private String year;

    private String fuelCapacity;

    private String color;

    private String bookingPrice;
}
