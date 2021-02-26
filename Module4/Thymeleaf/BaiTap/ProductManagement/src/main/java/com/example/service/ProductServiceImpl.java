package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductServiceImpl implements ProductService {

    static Map<String, Product> productList;

    static {
        productList = new TreeMap<>();
        productList.put("Iphone 3", new Product("Iphone 3", 300D, "Apple"));
        productList.put("Iphone 4", new Product("Iphone 4", 400D, "Apple"));
        productList.put("Iphone 5", new Product("Iphone 5", 500D, "Apple"));
        productList.put("Iphone 6", new Product("Iphone 6", 600D, "Apple"));
        productList.put("Iphone 7", new Product("Iphone 7", 700D, "Apple"));
        productList.put("Iphone 8", new Product("Iphone 8", 800D, "Apple"));
        productList.put("Iphone X", new Product("Iphone X", 1000D, "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public String saveProduct(Product product) {
        for (String name : productList.keySet()) {
            if (product.getNameProduct().equals(name)) {
                return "NG";
            }
        }
        productList.put(product.getNameProduct(), product);
        return "OK";
    }

    @Override
    public void deleteProduct(String name) {
        productList.remove(name);
    }

    @Override
    public void updateProduct(String name, Product product) {
        productList.put(name, product);
    }

    @Override
    public Product findByName(String name) {
        return productList.get(name);
    }
}
