package com.company.event;

import org.springframework.context.ApplicationEvent;

public class OrderCreatedEvent extends ApplicationEvent {

    public OrderCreatedEvent(Object source) {
        super(source);
    }
}
