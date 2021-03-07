package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;
    private Integer quantity;


    @OneToMany(mappedBy = "orderProduct")
    private Set<OrderProductDetail> orderProductDetails = new HashSet<>();

    public OrderProduct() {
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Integer getIdOder() {
        return idOrder;
    }

    public void setIdOder(Integer idOder) {
        this.idOrder = idOder;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
