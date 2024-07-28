package com.example.ecomerce.oreder.service;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreationDTO {
    private Long userId;
    private List<Long> productIds;
    private String customerAddress;
    private Integer quantity;
    private Double price;
}
