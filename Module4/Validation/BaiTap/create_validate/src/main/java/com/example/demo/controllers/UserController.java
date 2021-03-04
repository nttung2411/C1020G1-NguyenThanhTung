package com.example.demo.controllers;


import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/")
    public String showPage(Model model){
        model.addAttribute("user",new User());
        return "home";
    }

    @PostMapping("/")
    public String createUser(@Valid @ModelAttribute User user, BindingResult bindingResult,Model model){
        new User().validate(user,bindingResult);
        if(bindingResult.hasErrors()){
            return "home";
        }
        model.addAttribute("message","Created");
        return "home";
    }
}
