package com.example.demo.controllers;


import com.example.demo.models.Order;
import com.example.demo.models.Product;
import com.example.demo.service.OderService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OderController {
    @Autowired
    OderService oderService;

    @Autowired
    ProductService productService;

    @GetMapping("/{id}/addtocart")
    public String addToCart(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        Order order = new Order();
        order.setQuantity(1);
        oderService.createOder(order);
        redirectAttributes.addFlashAttribute("message","Added to cart ");
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String showCart(Model model, Pageable pageable){
        Page<Product> products = productService.findAll(pageable);
        model.addAttribute("products",products);
        return "showcart";
    }
}
