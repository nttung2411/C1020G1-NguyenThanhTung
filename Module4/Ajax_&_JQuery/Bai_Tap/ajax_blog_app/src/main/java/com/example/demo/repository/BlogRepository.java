package com.example.demo.repository;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Blog findByNameBlog(String name);
    Iterable<Blog> findAllByCategory(Category category);
    List<Blog> findAllByNameBlogContaining(String name);
}
