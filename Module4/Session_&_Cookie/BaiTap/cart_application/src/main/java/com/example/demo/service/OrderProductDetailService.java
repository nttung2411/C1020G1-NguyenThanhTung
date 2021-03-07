package com.example.demo.service;

import com.example.demo.models.OrderProductDetail;

import java.util.List;


public interface OrderProductDetailService {
    List<OrderProductDetail> findAll();
    void create(OrderProductDetail orderProductDetail);
    OrderProductDetail update(String id);
    void deleteOrderProductDetail(Integer id);
}
