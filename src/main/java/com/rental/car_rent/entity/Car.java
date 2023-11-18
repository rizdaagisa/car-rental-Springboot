package com.rental.car_rent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "m_car")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    private String name;

    private String model;

    private String year;

    private String fuelCapacity;

    private String color;

    private String bookingPrice;

}