package com.rental.car_rent.services;

import com.rental.car_rent.DTO.request.SaveCarRequest;
import com.rental.car_rent.DTO.request.UpdateCarRequest;
import com.rental.car_rent.DTO.response.CarResponse;

import java.util.List;

public interface CarService {

    CarResponse createNew(SaveCarRequest request);
    List<CarResponse> getall();
    CarResponse getById(String id);
    CarResponse updateCar(UpdateCarRequest id);
    void deleteCar(String id);

}
