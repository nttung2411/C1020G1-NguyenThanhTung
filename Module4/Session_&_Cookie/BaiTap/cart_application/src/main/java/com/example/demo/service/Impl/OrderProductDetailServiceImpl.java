package com.example.demo.service.Impl;

import com.example.demo.models.OrderProduct;
import com.example.demo.models.OrderProductDetail;
import com.example.demo.repository.OrderProductRepository;
import com.example.demo.repository.OrderProductDetailRepository;
import com.example.demo.service.OrderProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductDetailServiceImpl implements OrderProductDetailService {

    @Autowired
    OrderProductDetailRepository orderProductDetailRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @Override
    public List<OrderProductDetail> findAll() {
        return orderProductDetailRepository.findAll();
    }

    @Override
    public void create(OrderProductDetail orderProductDetail) {
        orderProductDetailRepository.save(orderProductDetail);
    }

    @Override
    public OrderProductDetail update(String string) {
        String[] array = string.split(",");

        Integer id = Integer.parseInt(array[0]);

        Integer calculation = Integer.parseInt(array[1]);

        OrderProductDetail orderProductDetail = orderProductDetailRepository.findById(id).orElse(null);

        OrderProduct orderProduct = orderProductDetail.getOrderProduct();

        if(calculation == -1 && orderProduct.getQuantity() > 1){
            orderProduct.setQuantity(orderProduct.getQuantity()-1);
        }else if(calculation == 1){
            orderProduct.setQuantity(orderProduct.getQuantity()+1);
        }

        return orderProductDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrderProductDetail(Integer id) {
        orderProductDetailRepository.deleteById(id);
    }
}
