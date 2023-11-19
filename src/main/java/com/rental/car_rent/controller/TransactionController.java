package com.rental.car_rent.controller;

import com.rental.car_rent.DTO.DataResponse;
import com.rental.car_rent.DTO.request.CustomerRequest;
import com.rental.car_rent.DTO.request.TransactionRequest;
import com.rental.car_rent.DTO.request.UpdateCustomerRequest;
import com.rental.car_rent.DTO.response.CustomerResponse;
import com.rental.car_rent.DTO.response.TransactionResponse;
import com.rental.car_rent.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> createNewTransaction(@RequestBody TransactionRequest request){
        TransactionResponse transactionResponse = transactionService.saveTransaction(request);
        DataResponse response = DataResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Succsess Save Data Transaction")
                .data(transactionResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping({"id"})
    public ResponseEntity<?> getTransactionByid(@RequestParam String id){
        TransactionResponse transactionResponse = transactionService.getById(id);
        DataResponse response = DataResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Succsess Save Get Data By ID")
                .data(transactionResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTransaction(){
        List<TransactionResponse> transactionResponse = transactionService.getAll();
        DataResponse response = DataResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Succsess Get All data transaction")
                .data(transactionResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
