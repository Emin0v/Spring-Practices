package com.company.service;

import com.company.model.Notification;

public interface NotificationService {

    public void sendToQueue(Notification notification);
}
