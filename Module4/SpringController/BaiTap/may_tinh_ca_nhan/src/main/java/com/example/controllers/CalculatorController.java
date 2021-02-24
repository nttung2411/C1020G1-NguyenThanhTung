package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String getCalculatorPage(){
        return "index";
    }

    @GetMapping("/result")
    public String calculator(@RequestParam String calculator ,
                             @RequestParam Double number1 ,
                             @RequestParam Double number2 ,
                             Model model){
        String result = null;
        double resultNumber;
        switch (calculator){
            case "+":
                resultNumber = number1 + number2;
                result = "Result Addition: " + resultNumber;
                break;
            case "-":
                resultNumber = number1 - number2;
                result = "Result Subtraction: " + resultNumber;
                break;
            case "*":
                resultNumber = number1 * number2;
                result = "Result Multiplication: " + resultNumber;
                break;
            case "/":
                if (number2 == 0){
                    result = "Can't Division By Zero";
                } else {
                    resultNumber = number1 / number2;
                    result = "Result Division: " + resultNumber;
                }
                break;
        }
        model.addAttribute("result",result);
        return "index";
    }
}
