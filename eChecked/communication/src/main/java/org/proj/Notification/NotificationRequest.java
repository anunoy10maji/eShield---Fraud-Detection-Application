package org.proj.Notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequest {

    private Long id;
    private String sent_from;
    private String sent_to_email;
    private String sent_to_customerId;
    private String message;
    private LocalDateTime sent_at;
    private String token;
}

