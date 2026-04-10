package com.saka.order_service.service;

import com.saka.order_service.dto.OrderRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String placeOrder(OrderRequest request) {

        // 1. Check inventory
        Boolean inStock = restTemplate.getForObject(
                "http://localhost:8082/inventory/check/" + request.getProduct(),
                Boolean.class
        );

        if (!Boolean.TRUE.equals(inStock)) {
            return "Out of stock";
        }

        // 2. Process payment
        restTemplate.postForObject(
                "http://localhost:8083/payment/process",
                "Payment for " + request.getProduct(),
                String.class
        );

        // 3. Send notification
        restTemplate.postForObject(
                "http://localhost:8084/notify",
                "Order placed for " + request.getProduct(),
                String.class
        );

        return "Order placed successfully";
    }
}
