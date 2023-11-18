package com.rental.car_rent.DTO.request;

import lombok.Data;

@Data
public class CarRequest {

    private String name;

    private String model;

    private String year;

    private String fuelCapacity;

    private String color;

    private String bookingPrice;

}
