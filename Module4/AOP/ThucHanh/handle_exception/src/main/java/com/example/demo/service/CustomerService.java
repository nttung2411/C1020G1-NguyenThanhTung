package com.example.demo.service;


import com.example.demo.model.Customer;
import com.example.demo.service.exception.DuplicateEmailException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageInfo);

    List<Customer> search(String keyword);

    Page<Customer> search(String keyword, Pageable pageInfo);

    Customer findOne(Long id) throws Exception;

    Customer save(Customer customer) throws DuplicateEmailException;

    List<Customer> save(List<Customer> customers);

    boolean exists(Long id);

    List<Customer> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
