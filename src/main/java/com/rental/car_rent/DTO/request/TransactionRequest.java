package com.rental.car_rent.DTO.request;

import com.rental.car_rent.DTO.response.CarResponse;
import com.rental.car_rent.DTO.response.CustomerResponse;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class TransactionRequest {

    @NotBlank(message = "id required")
    private String id;
    @NotBlank(message = "startDate required")
    private Date startDate;
    @NotBlank(message = "endDate required")
    private Date endDate;
    @NotBlank(message = "totalPrice required")
    private String totalPrice;
    @NotBlank(message = "id_car required")
    private String car_id;
    @NotBlank(message = "id_customer required")
    private String customer_id;

}
