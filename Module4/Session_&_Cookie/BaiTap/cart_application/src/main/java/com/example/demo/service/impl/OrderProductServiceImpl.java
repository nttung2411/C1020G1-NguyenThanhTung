package com.example.demo.service.impl;

import com.example.demo.models.OrderProduct;
import com.example.demo.repository.OrderProductRepository;
import com.example.demo.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    OrderProductRepository orderProductRepository;

    @Override
    public void createOrder(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
    }

    @Override
    public Page<OrderProduct> findAll(Pageable pageable) {
        return orderProductRepository.findAll(pageable);
    }

    @Override
    public void deleteOrder(OrderProduct orderProduct) {
        orderProductRepository.delete(orderProduct);
    }
}
