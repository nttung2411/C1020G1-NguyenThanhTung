package com.example.demo.service;

import com.example.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    void createProduct(Product product);
    Product findById(Integer id);
    Page<Product> findAll(Pageable pageable);
}
