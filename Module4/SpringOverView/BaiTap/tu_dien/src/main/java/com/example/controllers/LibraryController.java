package com.example.controllers;

import com.example.service.ServiceLibrary;
import com.example.service.ServiceLibraryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {

    ServiceLibrary serviceLibrary = new ServiceLibraryImpl();

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/result")
    public String translate(@RequestParam String word , Model model){
        String tiengViet = serviceLibrary.translate(word);
        model.addAttribute("tiengAnh",word);
        model.addAttribute("tiengViet",tiengViet);
        return "result";
    }
}
