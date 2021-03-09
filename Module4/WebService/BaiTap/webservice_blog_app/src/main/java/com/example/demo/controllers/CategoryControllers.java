package com.example.demo.controllers;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryControllers {
    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> showCategory(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/blogOfCategories/{id}")
    public ResponseEntity<List<Blog>> showBlogOfCategories(@PathVariable Integer id, Model model){
        Category category = categoryService.findById(id);
        List<Blog> blogList = blogService.findAllByCategory(category);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
