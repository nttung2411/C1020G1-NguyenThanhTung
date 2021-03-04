package com.example.demo.service.Impl;

import com.example.demo.model.Renter;
import com.example.demo.repository.RenterRepository;
import com.example.demo.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RenterServiceImpl implements RenterService {
    @Autowired
    RenterRepository renterRepository;
    @Override
    public Renter findById(Integer id) {
        return renterRepository.findById(id).orElse(null);
    }

    @Override
    public void removeRenter(Renter renter) {
        renterRepository.delete(renter);
    }

    @Override
    public void createRenter(Renter renter) {
        renterRepository.save(renter);
    }
}
