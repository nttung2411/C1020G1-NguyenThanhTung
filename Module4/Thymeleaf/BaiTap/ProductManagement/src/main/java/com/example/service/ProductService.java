package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    String saveProduct(Product product);
    void deleteProduct(String name);
    void updateProduct(String name,Product product);
    Product findByName(String name);
}
