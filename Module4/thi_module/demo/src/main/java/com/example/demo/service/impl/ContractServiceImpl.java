package com.example.demo.service.impl;

import com.example.demo.models.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;


    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Contract findById(String id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public void deleteById(String id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> search(String keyword, Pageable pageable) {
        return contractRepository.searchByInputText(keyword, pageable);
    }
}
