package com.example.ecomerce.oreder.controller;

import com.example.ecomerce.oreder.service.OrderCreationDTO;
import com.example.ecomerce.oreder.service.OrderDTO;
import com.example.ecomerce.oreder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderCreationDTO orderCreationDTO) {
        OrderDTO orderDTO = orderService.createOrder(orderCreationDTO);
        return ResponseEntity.ok(orderDTO);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getUserOrderHistory(@PathVariable Long userId) {
        List<OrderDTO> orderHistory = orderService.getUserOrderHistory(userId);
        return ResponseEntity.ok(orderHistory);
    }
}
