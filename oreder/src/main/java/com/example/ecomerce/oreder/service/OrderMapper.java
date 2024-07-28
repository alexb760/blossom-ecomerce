package com.example.ecomerce.oreder.service;

import com.example.ecomerce.oreder.domain.Order;
import com.example.ecomerce.oreder.domain.OrderProduct;
import com.example.ecomerce.oreder.domain.Product;
import com.example.ecomerce.oreder.domain.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDTO toDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        User user = order.getUser();

        orderDTO.setId(order.getId());
        orderDTO.setUserId(order.getUser().getId());
        orderDTO.setUserName(user.getUsername());
        orderDTO.setEmail(user.getEmail());

        orderDTO.setOrderDetail(
                order.getOrderProducts().stream().map(this::mapOrderProductDetail).collect(Collectors.toList()));

        return orderDTO;
    }

    public OrderDetailDTO mapOrderProductDetail(OrderProduct orderProduct){
        OrderDetailDTO detail = new OrderDetailDTO();
        detail.setId(orderProduct.getId());
        detail.setQuantity(orderProduct.getQuantity());
        detail.setPrice(orderProduct.getPrice());
        detail.setProducts(mapProductDetailOrderToDto(orderProduct.getProduct()));
        return detail;
    }

    public List<ProductDto> mapProductDetailOrderToDto(Product product){
        ProductDto productDetail = new ProductDto();
        productDetail.setId(product.getId());
        productDetail.setName(product.getName());
        productDetail.setDescription(product.getDescription());
        productDetail.setPrice(product.getPrice());
        return   Collections.singletonList(productDetail);
    }
}
