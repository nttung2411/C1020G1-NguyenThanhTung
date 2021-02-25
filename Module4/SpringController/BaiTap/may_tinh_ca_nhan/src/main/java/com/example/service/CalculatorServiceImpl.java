package com.example.service;


import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calculation(String calculator,double number1,double number2) {
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
        return result;
    }
}
