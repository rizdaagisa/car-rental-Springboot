package com.rental.car_rent.services;

import com.rental.car_rent.DTO.request.CustomerRequest;
import com.rental.car_rent.DTO.request.UpdateCustomerRequest;
import com.rental.car_rent.DTO.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createNew(CustomerRequest request);
    List<CustomerResponse> getall();
    CustomerResponse getByID(String id);
    CustomerResponse updateCustomer(UpdateCustomerRequest request);
    void deleteCustomer(String id);
}
