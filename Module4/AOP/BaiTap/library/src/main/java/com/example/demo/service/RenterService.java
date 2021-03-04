package com.example.demo.service;

import com.example.demo.model.Renter;

public interface RenterService {
    Renter findById(Integer id);
    void removeRenter(Renter renter);
    void createRenter(Renter renter);
}
