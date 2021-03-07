package com.example.demo.service;

import com.example.demo.models.OrderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderProductService {
    void createOrder(OrderProduct orderProduct);
    Page<OrderProduct> findAll(Pageable pageable);
    void deleteOrder(OrderProduct orderProduct);
}
