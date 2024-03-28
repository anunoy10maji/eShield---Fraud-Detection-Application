package org.proj.Notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("notification")
public interface NotificationSendClient {

    @PostMapping("/notification/api/send")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
