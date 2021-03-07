package com.example.demo.repository;

import com.example.demo.models.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OderRepository  extends JpaRepository<Order,Integer> {
    Page<Order> findAll(Pageable pageable);
}
