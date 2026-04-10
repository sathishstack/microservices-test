package com.saka.inventory_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @GetMapping("/check/{product}")
    public boolean checkStock(@PathVariable String product) {
        System.out.println("Checking stock for: " + product);
        return true;
    }
}
