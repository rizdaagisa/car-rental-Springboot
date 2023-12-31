package com.rental.car_rent.repository;

import com.rental.car_rent.DTO.request.UpdateCarRequest;
import com.rental.car_rent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, String> {

    @Query(value = "SELECT * FROM Car c WHERE c.id = :id", nativeQuery = true)
    Optional<Car> getCarById(String id);

    @Query(value = "SELECT * FROM car", nativeQuery = true)
    List<Car> getAllCar();

}
