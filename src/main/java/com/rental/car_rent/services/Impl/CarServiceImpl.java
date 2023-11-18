package com.rental.car_rent.services.Impl;

import com.rental.car_rent.DTO.request.CarRequest;
import com.rental.car_rent.DTO.request.UpdateCarRequest;
import com.rental.car_rent.DTO.response.CarResponse;
import com.rental.car_rent.entity.Car;
import com.rental.car_rent.repository.CarRepository;
import com.rental.car_rent.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public CarResponse createNew(CarRequest request) {
        Car car = Car.builder()
                .name(request.getName())
                .model(request.getModel())
                .bookingPrice(request.getBookingPrice())
                .color(request.getColor())
                .fuelCapacity(request.getFuelCapacity())
                .year(request.getYear())
                .build();
        try {
            carRepository.save(car);
            return CarResponse.builder()
                    .name(request.getName())
                    .model(request.getModel())
                    .bookingPrice(request.getBookingPrice())
                    .color(request.getColor())
                    .fuelCapacity(request.getFuelCapacity())
                    .year(request.getYear())
                    .build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public List<CarResponse> getall() {
        try {
            List<Car> all = carRepository.findAll();
            List<CarResponse> response= new ArrayList<>();
            all.forEach(car -> response.add(
                    CarResponse.builder()
                            .name(car.getName())
                            .model(car.getModel())
                            .bookingPrice(car.getBookingPrice())
                            .color(car.getColor())
                            .fuelCapacity(car.getFuelCapacity())
                            .year(car.getYear())
                            .build()
            ));
            return response;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public CarResponse getById(String id) {
        try {
            Car car = carRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "data tidak ditemukan"));

            return CarResponse.builder()
                    .name(car.getName())
                    .model(car.getModel())
                    .bookingPrice(car.getBookingPrice())
                    .color(car.getColor())
                    .fuelCapacity(car.getFuelCapacity())
                    .year(car.getYear())
                    .build();

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public CarResponse updateCar(UpdateCarRequest request) {
        try {
            Car car = carRepository.findById(request.getId_car())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "data tidak ditemukan"));

            car.setName(request.getName());
            car.setBookingPrice(request.getBookingPrice());
            car.setColor(request.getColor());
            car.setModel(request.getModel());
            car.setYear(request.getYear());
            car.setFuelCapacity(request.getFuelCapacity());

            carRepository.save(car);
            return CarResponse.builder()
                    .name(car.getName())
                    .model(car.getModel())
                    .bookingPrice(car.getBookingPrice())
                    .color(car.getColor())
                    .fuelCapacity(car.getFuelCapacity())
                    .year(car.getYear())
                    .build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

    @Override
    public void deleteCar(String id) {
        try {
            Car car = carRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_GATEWAY, "data tidak ditemukan"));

            carRepository.delete(car);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }
}
