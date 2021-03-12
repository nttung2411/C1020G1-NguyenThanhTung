package com.example.demo.controllers;

import com.example.demo.util.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/")
    public String showLogin(){
        return "login";
    }

    @GetMapping("/pageHome")
    public String showHome(){
        return "home";
    }

    @GetMapping("/adminInfo")
    public String showAdmin(){
        return "admin";
    }

    @GetMapping("/userInfo")
    public String showUser(){
        return "user";
    }

    @GetMapping("/index")
    public String showIndex(){
        return "index";
    }

    @GetMapping("/403")
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
}
