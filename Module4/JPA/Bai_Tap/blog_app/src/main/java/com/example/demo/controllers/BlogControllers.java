package com.example.demo.controllers;


import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogControllers {

    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public String showHome(Model model){
        model.addAttribute("blogList",blogService.findAllBlog());
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
        return "create";
    }

    @PostMapping("/save")
    public String createBlog(Blog blog){
        blogService.saveBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable Integer id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "create";
    }

    @GetMapping("/{id}/read")
    public String showBlog(@PathVariable Integer id , Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "showblog";
    }
}
