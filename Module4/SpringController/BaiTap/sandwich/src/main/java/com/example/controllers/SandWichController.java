package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
public class SandWichController {


    @GetMapping("/sandwich")
    public String getSandwichPage(){
        return "index";
    }

    @GetMapping("/sandwich/spice")
    public String getSpiceSandwich(Model model , @RequestParam("condiment") String[] condiment){
        model.addAttribute("listSpice", Arrays.toString(condiment));
        return "spice";
    }
}
