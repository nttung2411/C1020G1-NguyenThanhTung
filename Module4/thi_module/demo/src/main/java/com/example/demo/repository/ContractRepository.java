package com.example.demo.repository;

import com.example.demo.models.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract,String> {
    Page<Contract> findAll(Pageable pageable);
    @Query("select c from Contract c where (c.customer.nameCustomer like %?1%) or (c.typeService like %?1%)")
    Page<Contract> searchByInputText(String keyword,Pageable pageable);
}
