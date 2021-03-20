package com.example.demo.controllers;
import com.example.demo.models.employee.Employee;
import com.example.demo.models.employee.FuramaUser;
import com.example.demo.service.employee_service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
public class UserController {

    @Autowired
    EmployeeService employeeService;

    @ModelAttribute("nameEmployee")
    public String nameEmployee(Principal principal){
        try {
            if(principal.getName() == (null)){
                return "";
            }
        }catch (NullPointerException e){
            return "";
        }
        Employee employee = employeeService.findByUserName(principal.getName());
        return employee.getEmployeeName();
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
