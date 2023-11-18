package com.rental.car_rent.services.Impl;

import com.rental.car_rent.DTO.request.CustomerRequest;
import com.rental.car_rent.DTO.request.UpdateCustomerRequest;
import com.rental.car_rent.DTO.response.CustomerResponse;
import com.rental.car_rent.entity.Customer;
import com.rental.car_rent.repository.CustomerRepository;
import com.rental.car_rent.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponse createNew(CustomerRequest request) {
        Customer customer = Customer.builder()
                .name(request.getName())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .build();
        try {
            customerRepository.save(customer);
            return CustomerResponse.builder()
                    .name(request.getName())
                    .address(request.getAddress())
                    .phoneNumber(request.getPhoneNumber())
                    .build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public List<CustomerResponse> getall() {
        try {
            List<Customer> all = customerRepository.findAll();
            List<CustomerResponse> response= new ArrayList<>();
            all.forEach(customer -> response.add(
                    CustomerResponse.builder()
                            .name(customer.getName())
                            .phoneNumber(customer.getPhoneNumber())
                            .address(customer.getAddress())
                            .build()
            ));
            return response;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public CustomerResponse getByID(String id) {
        try {
            Customer customer = customerRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "data tidak ditemukan"));

            return CustomerResponse.builder()
                    .name(customer.getName())
                    .phoneNumber(customer.getPhoneNumber())
                    .address(customer.getAddress())
                    .build();

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public CustomerResponse updateCustomer(UpdateCustomerRequest request) {
        try {
            Customer customer = customerRepository.findById(request.getCustomer_id())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "data tidak ditemukan"));

            customer.setName(request.getName());
            customer.setAddress(request.getAddress());
            customer.setPhoneNumber(request.getPhoneNumber());

            customerRepository.save(customer);
            return CustomerResponse.builder()
                    .name(customer.getName())
                    .address(customer.getAddress())
                    .phoneNumber(customer.getPhoneNumber())
                    .build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public void deleteCustomer(String id) {
        try {
            Customer customer = customerRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "data tidak ditemukan"));

            customerRepository.delete(customer);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }
}