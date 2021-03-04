package com.example.demo.controllers;


import com.example.demo.aop.WriteFile;
import com.example.demo.model.Book;
import com.example.demo.model.Renter;
import com.example.demo.service.BookService;
import com.example.demo.service.RenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RenterController {
    @Autowired
    RenterService renterService;

    @Autowired
    BookService bookService;

    @GetMapping("/{id}/rent")
    public String showRentBook(@PathVariable Integer id, RedirectAttributes redirectAttributes,Model model){
        Book book = bookService.findById(id);
        if(book.getQuantity() > 0) {
            model.addAttribute("book",book);
            return "showrent";
        }
        redirectAttributes.addFlashAttribute("message","Quantity of " + book.getNameOfBook() + " has run out");
        return "redirect:/";
    }

    @GetMapping("/{id}/rented")
    public String saveRentBook(@PathVariable Integer id){
        Book book = bookService.findById(id);

        Renter renter = new Renter();
        renter.setBook(book);

        bookService.rentBook(book);
        renterService.createRenter(renter);

        WriteFile.nameOfBook = book.getNameOfBook();
        return "redirect:/";
    }

    @GetMapping("/refundbook")
    public String showRefundBook(){
        return "refundbook";
    }

    @PostMapping("/refundbook")
    public String refundBook(@RequestParam Integer idRenter , Model model){
        Renter renter = renterService.findById(idRenter);
        if (renter == null){
            model.addAttribute("message","Not found");
            model.addAttribute("idRenter",idRenter);
            return "refundbook";
        }

        bookService.updateRent(renter.getBook());
        renterService.removeRenter(renter);
        WriteFile.nameOfBook = renter.getBook().getNameOfBook();
        return "redirect:/";
    }
}
