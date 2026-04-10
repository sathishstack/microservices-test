package com.saka.payment_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/process")
    public String processPayment(@RequestBody String request) {
        System.out.println("Payment processed: " + request);
        return "Payment successful";
    }
}