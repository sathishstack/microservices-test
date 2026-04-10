package com.saka.inventory_service.controller;

import com.saka.inventory_service.entity.Product;
import com.saka.inventory_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/check/{product}")
    public boolean checkStock(@PathVariable String product) {
        return productRepository.findByName(product).map(p -> p.getQuantity() > 0).orElse(false);
    }

    @PostMapping(path = "/add")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
