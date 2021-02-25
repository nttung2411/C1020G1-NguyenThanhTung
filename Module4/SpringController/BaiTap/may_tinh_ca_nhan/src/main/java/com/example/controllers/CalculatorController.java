package com.example.controllers;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public String getCalculatorPage(){
        return "index";
    }

    @GetMapping("/result")
    public String calculator(@RequestParam String calculator ,
                             @RequestParam Double number1 ,
                             @RequestParam Double number2 ,
                             Model model){
        String result = calculatorService.calculation(calculator,number1,number2);
        model.addAttribute("result",result);
        return "index";
    }
}
