package com.rental.car_rent.DTO.response;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Builder
@Data
public class TransactionResponse {

    private String id;

    private Date startDate;

    private Date endDate;

    private String totalPrice;

    private CarResponse car_details;

    private CustomerResponse customer_details;

}
