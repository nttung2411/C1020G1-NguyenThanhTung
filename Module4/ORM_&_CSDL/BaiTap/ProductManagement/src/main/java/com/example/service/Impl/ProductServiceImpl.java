package com.example.service.Impl;

import com.example.model.Product;
import com.example.repository.ProductRepo;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        productRepo.saveProduct(product);
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        productRepo.deleteProduct(idProduct);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.updateProduct(product);
    }

    @Override
    public Product findById(Integer idProduct) {
        return productRepo.findById(idProduct);
    }
}
