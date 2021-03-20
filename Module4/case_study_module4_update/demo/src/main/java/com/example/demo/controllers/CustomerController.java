package com.example.demo.controllers;

import com.example.demo.models.customer.Customer;
import com.example.demo.models.customer.CustomerType;
import com.example.demo.service.customer_service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;



    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypeList(){
        return customerService.findAllCustomerType();
    }

    @GetMapping("/customerCreate")
    public String showCreateCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "/customer/create";
    }

    @PostMapping("/customerCreate")
    public String saveCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            return "customer/create";
        }
        String checkDuplicate =customerService.checkDuplicate(customer);
        if(checkDuplicate != null){
            model.addAttribute("messageDuplicate",checkDuplicate);
            return "customer/create";
        }
        customerService.saveCustomer(customer);
        return "redirect:/customerShowlist";
    }

    @GetMapping("/customerShowlist")
    public String showListCustomer(Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("customerList",customerService.findAll(pageable));
        return "/customer/showlist";
    }

    @GetMapping("/customerEdit/{id}")
    public String showEditCustomer(Model model, @PathVariable String id){
        model.addAttribute("customer",customerService.findById(id));
        return "/customer/edit";
    }

    @PostMapping("/customerEdit")
    public String editCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customer",customer);
            return "/customer/edit";
        }

        String checkDuplicate = customerService.checkDuplicate(customer);
        if(checkDuplicate != null && !checkDuplicate.equals("Mã khách hàng đã tồn tại")){
            model.addAttribute("messageDuplicate",checkDuplicate);
            return "/customer/edit";
        }

        customerService.saveCustomer(customer);
        return "redirect:/customerShowlist";
    }

    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam String id){
        customerService.deleteById(id);
        return "redirect:/customerShowlist";
    }

    @GetMapping("/customer/search")
    public String searchCustomer(@RequestParam("nameCustomer") String name, Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("listCustomer",customerService.findAllCustomerByName(pageable,name));
        return "/customer/showlist";
    }


}
