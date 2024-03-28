package org.proj.Service;

import lombok.extern.slf4j.Slf4j;
import org.proj.Dtos.NotificationRequest;
import org.proj.Entity.Notification;
import org.proj.Repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    public void send(NotificationRequest notificationRequest) {

        Notification notification = Notification.builder().sent_from(notificationRequest.getSent_from())
                .message(notificationRequest.getMessage()).sent_at(notificationRequest.getSent_at())
                .sent_to_email(notificationRequest.getSent_to_email())
                .sent_to_customerId(notificationRequest.getSent_to_customerId())
                .token(notificationRequest.getToken())
                .build();

        notificationRepo.save(notification);
    }
}
