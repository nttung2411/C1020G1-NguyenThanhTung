package com.example.demo.service.Impl;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {



    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog findByName(String name) {
        return blogRepository.findByNameBlog(name);
    }

    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findByOrderByDateDesc(pageable);
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }


    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void removeBlog(Integer id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        blogRepository.delete(blog);
    }

    @Override
    public Iterable<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }
}
