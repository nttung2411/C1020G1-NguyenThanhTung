package com.example.demo.service;

import com.example.demo.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OderService {
    void createOder(Order order);
    Page<Order> findAll(Pageable pageable);
}
