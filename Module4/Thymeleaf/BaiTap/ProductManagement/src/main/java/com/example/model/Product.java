package com.example.model;

public class Product {
    String nameProduct;
    Double priceProduct;
    String manufacture;

    public Product(){}

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

    public Product(String nameProduct, Double priceProduct, String manufacture) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.manufacture = manufacture;
    }
}
