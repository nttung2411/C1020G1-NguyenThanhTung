package com.example.demo.controllers;

import com.example.demo.models.employee.Employee;
import com.example.demo.service.employee_service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

;


@Controller
public class UserController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
