package com.example.demo.controllers;


import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public String showHome(Model model ,@PageableDefault(size = 3) Pageable pageable){
        model.addAttribute("blogList",blogService.findAllBlog(pageable));
        return "home";
    }

    @GetMapping("/search")
    public String search(Model model ,@PageableDefault(size = 3) Pageable pageable, @RequestParam String name){
        if (blogService.findByName(name) == null){
            model.addAttribute("blogList",blogService.findAllBlog(pageable));
            model.addAttribute("messageSearch","Not found blog");
            return "home";
        }else{
            Integer id = blogService.findByName(name).getIdBlog();
            model.addAttribute("blog",blogService.findById(id));
            return "blog/showblog";
        }
    }

    @GetMapping("/blog/delete")
    public String deleteBlog(@RequestParam int id, RedirectAttributes redirectAttributes){
        blogService.removeBlog(id);
        redirectAttributes.addFlashAttribute("message","Deleted");
        return "redirect:/";
    }

    @GetMapping("/create/blog")
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

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable Integer id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/create";
    }

    @GetMapping("/{id}/read")
    public String showBlog(@PathVariable Integer id , Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "blog/showblog";
    }
}
