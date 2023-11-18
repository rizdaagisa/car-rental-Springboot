package com.rental.car_rent.repository;

import com.rental.car_rent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
