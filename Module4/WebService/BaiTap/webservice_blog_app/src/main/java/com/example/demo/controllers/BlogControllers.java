package com.example.demo.controllers;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@RestController
public class BlogControllers {

    @Autowired
    BlogService blogService;


    @GetMapping("/")
    public ResponseEntity<Page<Blog>> listBlog(Pageable pageable){
        return new ResponseEntity<>(blogService.findAllBlog(pageable), HttpStatus.OK);
    }


    @GetMapping("/{id}/read")
    public ResponseEntity<Blog> showBlog(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
}
