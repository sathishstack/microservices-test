package com.saka.order_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class OrderEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String product;
    private int quantity;

}