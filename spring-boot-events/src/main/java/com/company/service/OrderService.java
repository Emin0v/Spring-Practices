package com.company.service;

import com.company.dto.OrderCreateReqDTO;

public interface OrderService {

    void publishOrderEvent(OrderCreateReqDTO dto);
}
