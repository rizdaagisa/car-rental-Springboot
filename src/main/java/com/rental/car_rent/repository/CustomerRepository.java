package com.rental.car_rent.repository;

import com.rental.car_rent.entity.Car;
import com.rental.car_rent.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "SELECT * FROM Customer c WHERE c.id = :id", nativeQuery = true)
    Optional<Customer> getCustomerById(String id);

    @Query(value = "SELECT * FROM customer", nativeQuery = true)
    List<Customer> getAllCustomer();
}
