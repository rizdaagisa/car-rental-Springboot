package com.rental.car_rent.services.Impl;

import com.rental.car_rent.DTO.request.SaveCarRequest;
import com.rental.car_rent.DTO.request.UpdateCarRequest;
import com.rental.car_rent.DTO.response.CarResponse;
import com.rental.car_rent.repository.CarRepository;
import com.rental.car_rent.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;


    @Override
    public CarResponse createNew(SaveCarRequest request) {
        return null;
    }

    @Override
    public List<CarResponse> getall() {
        return null;
    }

    @Override
    public CarResponse getById(String id) {
        return null;
    }

    @Override
    public CarResponse updateCar(UpdateCarRequest id) {
        return null;
    }

    @Override
    public void deleteCar(String id) {

    }
}
