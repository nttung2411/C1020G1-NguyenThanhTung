package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeMoneyController {
    @GetMapping("/exchange")
    public String exchange(){
        return "index";
    }

    @GetMapping("/result")
    public String result(@RequestParam String usd , Model model) {
        double vnd = Double.parseDouble(usd)*20000;
        model.addAttribute("vnd",vnd);
        model.addAttribute("usd",usd);
        return "result";
    }
}
