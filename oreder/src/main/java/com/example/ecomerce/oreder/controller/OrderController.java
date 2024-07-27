package com.example.ecomerce.oreder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api/order")
public class OrderController {

    @GetMapping
    public String getOrder(){
        return "This are all the orders...";
    }
}
