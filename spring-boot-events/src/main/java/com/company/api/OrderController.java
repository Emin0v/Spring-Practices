package com.company.api;

import com.company.dto.OrderCreateReqDTO;
import com.company.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody OrderCreateReqDTO dto) {
        orderService.publishOrderEvent(dto);
        System.out.println("--The process starting for order creation--");
    }
}
