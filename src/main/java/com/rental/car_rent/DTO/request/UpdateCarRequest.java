package com.rental.car_rent.DTO.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateCarRequest {

    private String id_car;

    private String name;

    private String model;

    private String year;

    private String fuelCapacity;

    private String color;

    private String bookingPrice;
}
