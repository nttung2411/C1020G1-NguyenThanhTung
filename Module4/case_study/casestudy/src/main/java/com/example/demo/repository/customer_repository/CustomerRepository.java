package com.example.demo.repository.customer_repository;

import com.example.demo.models.customer.Customer;
import com.example.demo.models.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
