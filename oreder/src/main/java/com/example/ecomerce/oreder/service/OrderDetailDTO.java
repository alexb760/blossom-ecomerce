package com.example.ecomerce.oreder.service;

import lombok.Data;

import java.util.List;

@Data
public class OrderDetailDTO {
    private Long id;
    private Integer quantity;
    private Double price;
    private List<ProductDto> products;
}
