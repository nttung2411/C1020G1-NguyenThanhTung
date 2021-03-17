package com.example.demo.service.contract_service.impl;

import com.example.demo.models.contract.AttachService;
import com.example.demo.models.contract.Contract;
import com.example.demo.models.contract.ContractDetail;
import com.example.demo.repository.contract_repository.AttachServiceRepository;
import com.example.demo.repository.contract_repository.ContractDetailRepository;
import com.example.demo.repository.contract_repository.ContractRepository;
import com.example.demo.service.contract_service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Autowired
    ContractDetailRepository contractDetailRepository;

    @Override
    public void createContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> findContract(String search, Pageable pageable) {
        return contractRepository.findContractByDate(search,pageable);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void createContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }
}
