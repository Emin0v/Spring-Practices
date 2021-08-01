package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderCreateReqDTO {

    private String orderId;
    private String userId;
    private Integer count;
    private BigDecimal price;
}
