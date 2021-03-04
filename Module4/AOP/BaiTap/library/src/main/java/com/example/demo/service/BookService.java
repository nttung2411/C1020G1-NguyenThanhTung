package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    void createBook(Book book);
    void rentBook(Book book);
    void updateRent(Book book);
    Page<Book> findAll(Pageable pageable);
    Book findById(Integer id);
}
