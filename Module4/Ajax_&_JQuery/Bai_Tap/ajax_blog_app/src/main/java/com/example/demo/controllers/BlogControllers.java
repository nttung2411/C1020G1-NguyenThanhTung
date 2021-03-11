package com.example.demo.controllers;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class BlogControllers {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }


    @GetMapping("/blog/delete")
    public String deleteBlog(@RequestParam int id, RedirectAttributes redirectAttributes){
        blogService.removeBlog(id);
        redirectAttributes.addFlashAttribute("message","Deleted");
        return "redirect:/";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String createBlog(Blog blog){
        blog.setDate(new Date());
        blogService.saveBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable Integer id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/create";
    }

    @GetMapping("/read/{id}")
    public String showBlog(@PathVariable Integer id , Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/showblog";
    }
}
