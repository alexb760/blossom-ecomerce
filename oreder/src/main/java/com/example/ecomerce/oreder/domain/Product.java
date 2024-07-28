package com.example.ecomerce.oreder.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders = new HashSet<>();
}
