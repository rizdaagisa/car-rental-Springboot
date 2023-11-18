package com.rental.car_rent.controller;

import com.rental.car_rent.DTO.DataResponse;
import com.rental.car_rent.DTO.request.CarRequest;
import com.rental.car_rent.DTO.request.UpdateCarRequest;
import com.rental.car_rent.DTO.response.CarResponse;
import com.rental.car_rent.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarController {

    private CarService carService;

    @PostMapping
    public ResponseEntity<?> saveCar(@RequestBody CarRequest request){
        CarResponse carResponse = carService.createNew(request);
        DataResponse response = DataResponse.builder()
                .message("Succsessfuly create Car")
                .statusCode(HttpStatus.OK.value())
                .data(carResponse)
                .build();
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarByID(@PathVariable String id) {
        CarResponse carResponse = carService.getById(id);
        DataResponse response = DataResponse.builder()
                .message("successfully get customer by id")
                .statusCode(HttpStatus.OK.value())
                .data(carResponse)
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<?> getAllCar() {
        List<CarResponse> carResponses = carService.getall();

        DataResponse response = DataResponse.builder()
                .message("successfully get all customer")
                .statusCode(HttpStatus.OK.value())
                .data(carResponses)
                .build();

        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateCar(@RequestBody UpdateCarRequest request) {
        CarResponse carResponse = carService.updateCar(request);
        DataResponse response = DataResponse.builder()
                .message("successfully update customer")
                .statusCode(HttpStatus.OK.value())
                .data(carResponse)
                .build();
        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarByID(@PathVariable String id) {
        carService.deleteCar(id);
        DataResponse<?> response = DataResponse.builder()
                .message("successfully update customer")
                .statusCode(HttpStatus.OK.value())
                .data("OK")
                .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
