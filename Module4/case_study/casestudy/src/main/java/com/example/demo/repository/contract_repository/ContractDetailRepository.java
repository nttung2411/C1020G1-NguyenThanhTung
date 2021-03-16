package com.example.demo.repository.contract_repository;

import com.example.demo.models.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer>{
}
