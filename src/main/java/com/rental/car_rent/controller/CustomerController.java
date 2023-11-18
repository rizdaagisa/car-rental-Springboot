package com.rental.car_rent.controller;

import com.rental.car_rent.DTO.DataResponse;
import com.rental.car_rent.DTO.request.CustomerRequest;
import com.rental.car_rent.DTO.request.UpdateCustomerRequest;
import com.rental.car_rent.DTO.response.CustomerResponse;
import com.rental.car_rent.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/customer")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createNewCustomer(@RequestBody CustomerRequest request){
        CustomerResponse customerResponse = customerService.createNew(request);
        DataResponse response = DataResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Succsess Save Data Customer")
                .data(customerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping({"id"})
    public ResponseEntity<?> getCustomer(@RequestParam String id){
        CustomerResponse customerResponse = customerService.getByID(id);
        DataResponse response = DataResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Succsess Save Data Customer")
                .data(customerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping()
    public ResponseEntity<?> getAllCustomer(){
        List<CustomerResponse> customerResponse = customerService.getall();
        DataResponse response = DataResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Succsess Save Data Customer")
                .data(customerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping({"id"})
    public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerRequest request){
        CustomerResponse customerResponse = customerService.updateCustomer(request);
        DataResponse response = DataResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Succsess Save Data Customer")
                .data(customerResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping({"id"})
    public ResponseEntity<?> updateCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        DataResponse response = DataResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Succsess Save Data Customer")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
