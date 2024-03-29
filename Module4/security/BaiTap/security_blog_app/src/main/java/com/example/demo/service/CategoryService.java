package com.example.demo.service;

import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Page<Category> findAllCategory(Pageable pageable);
    void saveCategory(Category category);
    Category findById(Integer id);
    void removeCategory(Integer id);
}
