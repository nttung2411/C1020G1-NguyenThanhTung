package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BlogService {
    Blog findByName(String name);
    Page<Blog> findAllBlog(Pageable pageable);
    void saveBlog(Blog blog);
    Blog findById(Integer id);
    void removeBlog(Integer id);
    Iterable<Blog> findAllByCategory(Category category);
}
