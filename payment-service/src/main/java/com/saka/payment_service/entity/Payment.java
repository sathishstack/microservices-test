package com.saka.payment_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private String product;
    private String status;

    // getters & setters

}
