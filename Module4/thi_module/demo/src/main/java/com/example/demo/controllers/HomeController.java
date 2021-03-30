package com.example.demo.controllers;

import com.example.demo.models.Contract;
import com.example.demo.models.Customer;
import com.example.demo.service.ContractService;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    ContractService contractService;

    @Autowired
    CustomerService customerService;

    @ModelAttribute("customerList")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/")
    public String homePage(Model model, Pageable pageable) {
        model.addAttribute("listContract", contractService.findAll(pageable));
        return "home";
    }

    @GetMapping("/createContract")
    public String createPage(Model model) {
        model.addAttribute("contract", new Contract());
        return "create";
    }

    @PostMapping("/createContract")
    public String saveContract(@Validated @ModelAttribute Contract contract, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        contractService.saveContract(contract);
        model.addAttribute("message", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/information{id}")
    public String showInfo(@PathVariable String id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        return "information";
    }

    @GetMapping("/delete")
    public String deleteContract(@RequestParam String id) {
        contractService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam("select") String select, @RequestParam("customerName") String name, Model model, Pageable pageable) {
        String search = select + name;
        model.addAttribute("listContract", contractService.search(search, pageable));
        return "home";
    }
}
