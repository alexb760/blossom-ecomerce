package com.example.ecomerce.oreder.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
//@Table(name = "order_product")
@Data
@NoArgsConstructor
public class OrderProduct implements Serializable {
//    @EmbeddedId
//    private OrderProductId id;
//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;
    private Double price;

    public OrderProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
