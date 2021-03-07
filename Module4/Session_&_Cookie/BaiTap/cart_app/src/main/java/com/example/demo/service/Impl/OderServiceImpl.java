package com.example.demo.service.Impl;

import com.example.demo.models.Order;
import com.example.demo.repository.OderRepository;
import com.example.demo.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OderServiceImpl implements OderService {

    @Autowired
    OderRepository oderRepository;

    @Override
    public void createOder(Order order) {
        oderRepository.save(order);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return oderRepository.findAll(pageable);
    }
}
