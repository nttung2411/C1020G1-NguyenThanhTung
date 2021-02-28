package com.example.model;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduct;
    private String nameProduct;
    private Double priceProduct;
    private String manufacture;

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public Product() {
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Product(Integer idProduct,String nameProduct, Double priceProduct, String manufacture) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.manufacture = manufacture;
    }


    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
}
