package com.company.service.impl;

import com.company.dto.OrderCreateReqDTO;
import com.company.event.OrderCreatedEvent;
import com.company.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Async
    @Override
    public void publishOrderEvent(OrderCreateReqDTO dto) {
        applicationEventPublisher.publishEvent(new OrderCreatedEvent(dto));
    }
}
