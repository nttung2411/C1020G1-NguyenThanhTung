package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

    Iterable<Customer> findAllByProvince(Province province);
}
