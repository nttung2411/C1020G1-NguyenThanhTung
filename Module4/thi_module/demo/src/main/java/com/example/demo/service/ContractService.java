package com.example.demo.service;

import com.example.demo.models.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    void saveContract(Contract contract);
    Contract findById(String id);
    Page<Contract> findAll(Pageable pageable);
    void deleteById(String id);
    Page<Contract> search(String keyword,Pageable pageable);
}
