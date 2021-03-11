package com.example.demo.service;

import com.example.demo.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ProvinceService {
    Iterable<Province> findAll();

    Province findById(Integer id);

    void save(Province province);

    void remove(Integer id);
}
