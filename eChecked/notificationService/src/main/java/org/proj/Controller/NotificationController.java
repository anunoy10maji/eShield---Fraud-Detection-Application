package org.proj.Controller;

import lombok.extern.slf4j.Slf4j;
import org.proj.Dtos.NotificationRequest;
import org.proj.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/notification/api/")
public class NotificationController {


    @Autowired
    private NotificationService notificationService;

    @PostMapping("send")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){

        notificationService.send(notificationRequest);

        log.debug("Notification is triggered to customer {} successfully at {}", notificationRequest.getSent_to_customerId(),
                notificationRequest.getSent_at());
    }
}
