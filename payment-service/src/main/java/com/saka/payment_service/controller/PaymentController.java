package com.saka.payment_service.controller;

import com.saka.payment_service.entity.Payment;
import com.saka.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @PostMapping("/process")
    public String processPayment(@RequestBody String request) {

        Payment payment = new Payment();
        payment.setProduct(request);
        payment.setStatus("SUCCESS");

        repository.save(payment);

        return "Payment successful";
    }
}