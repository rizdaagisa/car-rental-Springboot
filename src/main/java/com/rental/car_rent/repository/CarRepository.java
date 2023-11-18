package com.rental.car_rent.repository;

import com.rental.car_rent.DTO.request.UpdateCarRequest;
import com.rental.car_rent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    @Query(
            value = "SELECT * FROM Car c WHERE c.id = ?1",
            nativeQuery = true)
    Car getCarById(Integer id);

//    @Query(value = "SELECT * FROM Product p WHERE p.price > :#{#request.minPrice} AND p.price < :#{#request.maxPrice}", nativeQuery = true)
//    List<Car> findProductsInPriceRange(@Param("priceRange") UpdateCarRequest request);
}
