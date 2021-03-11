package com.example.demo.controllers;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.Impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogRestController {

    @Autowired
    BlogService blogService;

    @GetMapping("/listBlog/")
    public ResponseEntity<Page<Blog>> showHome(@PageableDefault(size = 5) Pageable pageable){
        return new ResponseEntity<>(blogService.findAllBlog(pageable), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam String name){
        return new ResponseEntity<>(blogService.findAllByName(name),HttpStatus.OK);
    }
}
