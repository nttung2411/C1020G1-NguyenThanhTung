package com.example.demo.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Product {
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Integer idProduct;
   private String nameProduct;
   private Integer priceProduct;
   private String imageProduct;


    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL)
    private Set<OrderProductDetail> orderProductDetails = new HashSet<>();

    public Product() {
    }


    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Integer priceProduct) {
        this.priceProduct = priceProduct;
    }
}
