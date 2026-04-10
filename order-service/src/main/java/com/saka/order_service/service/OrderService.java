package com.saka.order_service.service;

import com.saka.order_service.dto.OrderRequest;
import com.saka.order_service.entity.OrderEntity;
import com.saka.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private OrderRepository orderRepository;

    public String placeOrder(OrderRequest request) {

        try {
            // 1. inventory check
            Boolean inStock = webClient.get()
                    .uri("http://localhost:8082/inventory/check/" + request.getProduct())
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();

            if (!Boolean.TRUE.equals(inStock)) {
                return "Out of stock";
            }

            // 2. payment
            webClient.post()
                    .uri("http://localhost:8083/payment/process")
                    .bodyValue("Payment for " + request.getProduct())
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                            response -> Mono.error(new RuntimeException("Service error")))
                    .bodyToMono(String.class)
                    .block();

            // 3.
            webClient.post()
                    .uri("http://localhost:8084/notify")
                    .bodyValue("Order placed for " + request.getProduct())
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                            response -> Mono.error(new RuntimeException("Service error")))
                    .bodyToMono(String.class)
                    .block();

            OrderEntity order = new OrderEntity();
            order.setProduct(request.getProduct());
            order.setQuantity(request.getQuantity());

            orderRepository.save(order);

            return "Order placed successfully";


        } catch (Exception e) {
            return "Order failed: " + e.getMessage();
        }
    }

}
