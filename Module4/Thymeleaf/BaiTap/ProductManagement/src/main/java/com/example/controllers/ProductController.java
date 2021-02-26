package com.example.controllers;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String saveProduct(@ModelAttribute Product product, Model model){
        String result = productService.saveProduct(product);
        if (result.equals("NG")){
            model.addAttribute("message","Name Product is Exist");
            return "create";
        }else {
            model.addAttribute("message","Created");
            return "redirect:/";
        }
    }

    @GetMapping("/product/{name}/update")
    public String showUpdateProduct(@PathVariable String name,Model model){
        Product product = productService.findByName(name);
        model.addAttribute("product",product);
        return "update";
    }

    @PostMapping("/product/update")
    public String updateProduct(Product product,Model model){
        productService.updateProduct(product.getNameProduct(),product);
        model.addAttribute("message","Updated");
        return "redirect:/";
    }

    @GetMapping("/product/{name}/delete")
    public String deleteProduct(@PathVariable String name,Model model){
        productService.deleteProduct(name);
        model.addAttribute("message","Deleted");
        return "redirect:/";
    }
}
