package com.example.demo.repository.customer_repository;

import com.example.demo.models.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepository<CustomerType,Integer> {
}
