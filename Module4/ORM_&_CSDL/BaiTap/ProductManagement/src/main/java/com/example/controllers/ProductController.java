package com.example.controllers;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String showPageHome(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("products",productList);
        return "home";
    }

    @GetMapping("/product/create")
    public String showPageCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message","Created");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/update")
    public String showUpdateProduct(@PathVariable Integer id,Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "update";
    }

    @PostMapping("/product/update")
    public String updateProduct(Product product,RedirectAttributes redirectAttributes){
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("message","Updated");
        return "redirect:/";
    }

//    @GetMapping("/product/{id}/delete")
//    public String deleteProduct(@PathVariable Integer id,RedirectAttributes redirectAttributes){
//        productService.deleteProduct(id);
//        redirectAttributes.addFlashAttribute("message","Deleted");
//        return "redirect:/";
//    }

    @GetMapping("/product/delete")
    public String deleteProduct(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message","Deleted");
        return "redirect:/";
    }
}
