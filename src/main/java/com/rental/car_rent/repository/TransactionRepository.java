package com.rental.car_rent.repository;

import com.rental.car_rent.DTO.request.TransactionRequest;
import com.rental.car_rent.entity.Customer;
import com.rental.car_rent.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

    @Query(value = "SELECT t FROM Transaction t WHERE t.id = :transactionId", nativeQuery = true)
    Transaction getTransactionById(String transactionId);

    @Query(value = "SELECT t FROM Transaction t", nativeQuery = true)
    Transaction getTransactionAll();

    @Query(value = "INSERT INTO transaction (start_date, end_date, total_price, car_id, customer_id)" +
            " VALUES (:#{#request.startDate}, :#{#request.endDate}, :#{#request.totalPrice}, :#{#request.car_id}, :#{#request.customer_id)" , nativeQuery = true)
    void saveTransaction(@Param("request") TransactionRequest request);
}
