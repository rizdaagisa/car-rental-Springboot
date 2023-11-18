 package com.rental.car_rent.services;

 import com.rental.car_rent.DTO.request.TransactionRequest;
 import com.rental.car_rent.DTO.response.TransactionResponse;
 import com.rental.car_rent.entity.Transaction;
 import org.springframework.data.jpa.repository.Query;

 import java.util.List;

 public interface TransactionService {

    TransactionResponse saveTransaction(TransactionRequest request);
    List<TransactionResponse> getAll();
    TransactionResponse getById(String id);

}
