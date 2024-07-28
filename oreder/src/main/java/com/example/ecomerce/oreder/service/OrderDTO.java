package com.example.ecomerce.oreder.service;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Long userId;
    private String userName;
    private String email;
    private List<OrderDetailDTO> orderDetail;
//    private List<ProductDto> products;
}
