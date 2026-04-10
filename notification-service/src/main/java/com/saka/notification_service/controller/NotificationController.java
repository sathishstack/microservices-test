package com.saka.notification_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    @PostMapping
    public String sendNotification(@RequestBody String message) {
        System.out.println("Notification sent: " + message);
        return "Notification sent";
    }
}
