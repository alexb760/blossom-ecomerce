package com.example.ecomerce.oreder.service;

import com.example.ecomerce.oreder.domain.Order;
import com.example.ecomerce.oreder.domain.OrderProduct;
import com.example.ecomerce.oreder.domain.Product;
import com.example.ecomerce.oreder.domain.User;
import com.example.ecomerce.oreder.repository.OrderRepository;
import com.example.ecomerce.oreder.repository.ProductRepository;
import com.example.ecomerce.oreder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderMapper orderMapper;

    public OrderDTO createOrder(OrderCreationDTO orderCreationDTO) {
        Optional<User> userOptional = userRepository.findById(orderCreationDTO.getUserId());
        User user = userOptional.orElseThrow(() -> new RuntimeException("User not found"));

        List<Product> products = productRepository.findAllById(orderCreationDTO.getProductIds());
        if (products.size() != orderCreationDTO.getProductIds().size()) {
            throw new RuntimeException("Some products not found");
        }
        Order order = new Order();
        order.setUser(user);
        order.setCustomerAddress(orderCreationDTO.getCustomerAddress());

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (Product product : products) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setQuantity(orderCreationDTO.getQuantity());
            orderProduct.setPrice(orderCreationDTO.getPrice());
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);
            orderProducts.add(orderProduct);
        }
        order.setOrderProducts(orderProducts);

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    public List<OrderDTO> getUserOrderHistory(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream().map(orderMapper::toDto).collect(Collectors.toList());
    }
}
