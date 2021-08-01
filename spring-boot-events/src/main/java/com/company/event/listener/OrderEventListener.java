package com.company.event.listener;

import com.company.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @EventListener
    public void orderEventHandler(OrderCreatedEvent orderCreatedEvent){
        try {
            Thread.sleep(6000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("EventListener -> "+orderCreatedEvent.getSource().toString());
    }
}
