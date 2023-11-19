package com.rental.car_rent.services.Impl;

import com.rental.car_rent.DTO.request.TransactionRequest;
import com.rental.car_rent.DTO.response.CarResponse;
import com.rental.car_rent.DTO.response.CustomerResponse;
import com.rental.car_rent.DTO.response.TransactionResponse;
import com.rental.car_rent.entity.Car;
import com.rental.car_rent.entity.Customer;
import com.rental.car_rent.entity.Transaction;
import com.rental.car_rent.repository.CarRepository;
import com.rental.car_rent.repository.CustomerRepository;
import com.rental.car_rent.repository.TransactionRepository;
import com.rental.car_rent.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    @Override
    public TransactionResponse saveTransaction(TransactionRequest request) {
        Car car = carRepository.getCarById(request.getCar_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "id Car not found"));

        Customer customer = customerRepository.getCustomerById(request.getCustomer_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "id Customer not found"));
        try {
            Transaction transaction = Transaction.builder()
                    .startDate(request.getStartDate())
                    .endDate(request.getEndDate())
                    .totalPrice(request.getTotalPrice())
                    .car(car)
                    .customer(customer)
                    .build();
            transactionRepository.save(transaction);

            return TransactionResponse.builder()
                    .startDate(request.getStartDate())
                    .endDate(request.getEndDate())
                    .totalPrice(request.getTotalPrice())
                    .car_details(CarResponse.builder()
                            .name(car.getName())
                            .model(car.getModel())
                            .year(car.getYear())
                            .color(car.getColor())
                            .bookingPrice(car.getBookingPrice())
                            .fuelCapacity(car.getFuelCapacity())
                            .build())
                    .customer_details(CustomerResponse.builder()
                            .name(customer.getName())
                            .address(customer.getAddress())
                            .phoneNumber(customer.getPhoneNumber())
                            .build())
                    .build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public List<TransactionResponse> getAll() {
        try {
            List<Transaction> all = transactionRepository.getTransactionAll();
            List<TransactionResponse> response = new ArrayList<>();
            all.forEach(transaction -> response.add(TransactionResponse.builder()
                    .startDate(transaction.getStartDate())
                    .endDate(transaction.getEndDate())
                    .totalPrice(transaction.getTotalPrice())
                    .car_details(CarResponse.builder()
                            .id(transaction.getCar().getId())
                            .fuelCapacity(transaction.getCar().getFuelCapacity())
                            .model(transaction.getCar().getModel())
                            .bookingPrice(transaction.getCar().getBookingPrice())
                            .color(transaction.getCar().getColor())
                            .name(transaction.getCar().getName())
                            .build())
                    .customer_details(CustomerResponse.builder()
                            .id(transaction.getCustomer().getId())
                            .name(transaction.getCustomer().getName())
                            .address(transaction.getCustomer().getAddress())
                            .phoneNumber(transaction.getCustomer().getPhoneNumber())
                            .build())
                    .build()));

            return response;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public TransactionResponse getById(String id) {
        Transaction transaction = transactionRepository.getTransactionById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "id Car not found"));

        try {
            return TransactionResponse.builder()
                    .startDate(transaction.getStartDate())
                    .endDate(transaction.getEndDate())
                    .totalPrice(transaction.getTotalPrice())
                    .car_details(CarResponse.builder()
                            .name(transaction.getCar().getName())
                            .model(transaction.getCar().getModel())
                            .year(transaction.getCar().getYear())
                            .color(transaction.getCar().getColor())
                            .bookingPrice(transaction.getCar().getBookingPrice())
                            .fuelCapacity(transaction.getCar().getFuelCapacity())
                            .build())
                    .customer_details(CustomerResponse.builder()
                            .name(transaction.getCustomer().getName())
                            .address(transaction.getCustomer().getAddress())
                            .phoneNumber(transaction.getCustomer().getPhoneNumber())
                            .build())
                    .build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }
}
