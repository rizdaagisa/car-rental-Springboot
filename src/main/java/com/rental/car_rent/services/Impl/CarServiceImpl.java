package com.rental.car_rent.services.Impl;

import com.rental.car_rent.repository.CarRepository;
import com.rental.car_rent.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


}
