package com.example.demo.service.customer_service;

import com.example.demo.models.customer.Customer;
import com.example.demo.models.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer id);
    List<CustomerType> findAllCustomerType();
    void deleteById(Integer id);
}
