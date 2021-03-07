package com.example.demo.repository;

import com.example.demo.models.OrderProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductDetailRepository extends JpaRepository<OrderProductDetail,Integer> {
}
