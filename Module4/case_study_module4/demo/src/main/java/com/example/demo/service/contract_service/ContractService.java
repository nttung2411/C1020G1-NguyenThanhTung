package com.example.demo.service.contract_service;

import com.example.demo.models.contract.AttachService;
import com.example.demo.models.contract.Contract;
import com.example.demo.models.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContractService {
    void createContract(Contract contract);
    Page<Contract> findContract(String search, Pageable pageable);
    Page<Contract> findAll(Pageable pageable);
    void createContractDetail(ContractDetail contractDetail);
    List<AttachService> findAllAttachService();
}
