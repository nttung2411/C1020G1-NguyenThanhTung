package com.example.demo.controllers;

import com.example.demo.aop.WriteFile;
import com.example.demo.model.Book;
import com.example.demo.model.Renter;
import com.example.demo.service.BookService;
import com.example.demo.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BooksController {
    @Autowired
    BookService bookService;

    @Autowired
    RenterService renterService;

    @GetMapping("/")
    public String showPage(Model model, Pageable pageable){
        model.addAttribute("listBook",bookService.findAll(pageable));
        return "home";
    }

    @GetMapping("/create")
    public String showCreateBook(Model model){
        model.addAttribute("book",new Book());
        return "create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book){
        bookService.createBook(book);
        WriteFile.nameOfBook = book.getNameOfBook();
        return "redirect:/";
    }
}
