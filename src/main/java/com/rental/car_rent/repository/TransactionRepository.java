package com.rental.car_rent.repository;

import com.rental.car_rent.entity.Customer;
import com.rental.car_rent.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
