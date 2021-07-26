package com.company.producer;

import com.company.model.Notification;
import com.company.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationProducer implements Runnable{

    private final NotificationService notificationService;

    @Override
    public void run() {
        Notification notification = Notification
                .builder()
                .notificationId(UUID.randomUUID().toString())
                .createdAt(new Date())
                .seen(false)
                .message("Salam Mahammad, necesen?")
                .build();

        notificationService.sendToQueue(notification);
    }
}
