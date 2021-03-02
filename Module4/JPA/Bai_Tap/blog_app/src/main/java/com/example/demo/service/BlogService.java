package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAllBlog();
    void saveBlog(Blog blog);
    Blog findById(Integer id);
    void removeBlog(Integer id);
}
