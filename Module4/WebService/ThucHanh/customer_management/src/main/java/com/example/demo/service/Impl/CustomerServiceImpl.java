package com.example.demo.service.Impl;

import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }
}
