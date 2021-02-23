package model.bean;

public class Product {
    String nameProduct;
    Double priceProduct;
    Double discountProduct;
    Integer stockProduct;

    public Product(String nameProduct, Double priceProduct, Double discountProduct, Integer stockProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.discountProduct = discountProduct;
        this.stockProduct = stockProduct;
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

    public Double getDiscountProduct() {
        return discountProduct;
    }

    public void setDiscountProduct(Double discountProduct) {
        this.discountProduct = discountProduct;
    }

    public Integer getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(Integer stockProduct) {
        this.stockProduct = stockProduct;
    }
}
