package com.example.ecomerce.oreder.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> orderProducts = new ArrayList<>();


//    public void addProduct(List<Product> products) {
//        for (Product product : products) {
//            OrderProduct orderProduct = new OrderProduct(this, product);
//            orderProducts.add(orderProduct);
////            product.getOrderProducts().add(orderProduct);
//        }
//    }
}
