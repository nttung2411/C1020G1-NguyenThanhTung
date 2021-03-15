package com.example.demo.controllers;

import com.example.demo.models.customer.Customer;
import com.example.demo.models.customer.CustomerType;
import com.example.demo.service.customer_service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    CustomerService customerService;


    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypeList(){
        return customerService.findAllCustomerType();
    }

    @GetMapping("/customer/create")
    public String showCreateCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "/customer/create";
    }

    @PostMapping("/customer/create")
    public String saveCustomer(@ModelAttribute Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/showlist";
    }

    @GetMapping("/customer/showlist")
    public String showListCustomer(Model model,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("customerList",customerService.findAll(pageable));
        return "/customer/showlist";
    }

    @GetMapping("/{id}/customer/edit")
    public String showEditCustomer(Model model, @PathVariable Integer id){
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/customer/edit")
    public String editCustomer(@ModelAttribute Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/showlist";
    }

    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam Integer id){
        customerService.deleteById(id);
        return "redirect:/customer/showlist";
    }
}
