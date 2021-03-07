package com.example.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOder;
    private Integer quantity;


//    @OneToMany(mappedBy = "order")
//    private Set<Cart> carts = new HashSet<>();

    public Order(){
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Integer getIdOder() {
        return idOder;
    }

    public void setIdOder(Integer idOder) {
        this.idOder = idOder;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
