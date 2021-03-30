package com.example.demo.repository.customer_repository;

import com.example.demo.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    @Query("select c from Customer c where concat(c.customerName,c.customerPhone,c.customerEmail) like %?1%")
    Page<Customer> searchByInputText(String keyword,Pageable pageable);
    Customer findByCustomerEmail(String email);
}
