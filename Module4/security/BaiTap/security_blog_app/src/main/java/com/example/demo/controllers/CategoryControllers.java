package com.example.demo.controllers;

import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryControllers {
    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/create/category")
    public String showPage(Model model){
        model.addAttribute("category",new Category());
        return "category/create";
    }

    @PostMapping("/create/category")
    public String createCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/";
    }

    @GetMapping("/blogOfCategories/{id}")
    public String showBlogOfCategories(@PathVariable Integer id,Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        model.addAttribute("blogs",blogService.findAllByCategory(category));
        return "category/view";
    }
}
