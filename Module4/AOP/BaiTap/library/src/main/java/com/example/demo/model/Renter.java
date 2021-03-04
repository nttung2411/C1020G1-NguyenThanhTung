package com.example.demo.model;


import javax.persistence.*;

@Entity
public class Renter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer rentCode;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "idBook")
    private Book book;

    public Integer getRentCode() {
        return rentCode;
    }

    public void setRentCode(Integer rentCode) {
        this.rentCode = rentCode;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book books) {
        this.book = books;
    }
}
