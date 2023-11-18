package com.rental.car_rent.services;

import com.rental.car_rent.DTO.request.CustomerRequest;
import com.rental.car_rent.DTO.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createNew(CustomerRequest request);
    List<CustomerResponse> getall();
    CustomerResponse updateCar(String id);
    void deleteCar(String id);
}
