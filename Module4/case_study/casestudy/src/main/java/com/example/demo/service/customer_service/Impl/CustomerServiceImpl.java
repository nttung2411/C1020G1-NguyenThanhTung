package com.example.demo.service.customer_service.Impl;

import com.example.demo.models.customer.Customer;
import com.example.demo.models.customer.CustomerType;
import com.example.demo.repository.customer_repository.CustomerRepository;
import com.example.demo.repository.customer_repository.CustomerTypeRepository;
import com.example.demo.service.customer_service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }
}
