package com.saka.order_service.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequest {

    private String product;
    private int quantity;

}
