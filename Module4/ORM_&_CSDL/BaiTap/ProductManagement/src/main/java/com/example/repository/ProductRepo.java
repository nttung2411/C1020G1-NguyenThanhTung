package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface ProductRepo {
    List<Product> findAll();
    void saveProduct(Product product);
    void deleteProduct(Integer idProduct);
    void updateProduct(Product product);
    Product findById(Integer idProduct);
}
