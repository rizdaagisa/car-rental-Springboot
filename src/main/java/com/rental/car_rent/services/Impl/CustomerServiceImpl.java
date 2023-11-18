package com.rental.car_rent.services.Impl;

import com.rental.car_rent.DTO.request.CustomerRequest;
import com.rental.car_rent.DTO.request.UpdateCustomerRequest;
import com.rental.car_rent.DTO.response.CustomerResponse;
import com.rental.car_rent.repository.CustomerRepository;
import com.rental.car_rent.services.CustomerService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    @Override
    public CustomerResponse createNew(CustomerRequest request) {
        return null;
    }

    @Override
    public List<CustomerResponse> getall() {
        return null;
    }

    @Override
    public CustomerResponse getByID(String id) {
        return null;
    }

    @Override
    public List<CustomerResponse> updateCustomer(UpdateCustomerRequest request) {
        return null;
    }

    @Override
    public void deleteCustomer(String id) {

    }
}