package com.example.demo.repository.customer_repository;

import com.example.demo.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name);
}
