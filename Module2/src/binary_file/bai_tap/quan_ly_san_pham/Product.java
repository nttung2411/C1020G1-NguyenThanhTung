package binary_file.bai_tap.quan_ly_san_pham;


import java.io.Serializable;

public class Product implements Serializable {
    private String idProduct;
    private String nameProduct;
    private String manufacturerProduct;
    private int priceProduct;

    public Product(String idProduct, String nameProduct, String manufacturerProduct, int priceProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.manufacturerProduct = manufacturerProduct;
        this.priceProduct = priceProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getManufacturerProduct() {
        return manufacturerProduct;
    }

    public void setManufacturerProduct(String manufacturerProduct) {
        this.manufacturerProduct = manufacturerProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }


    @Override
    public String toString() {
        return "ID sản phẩm = " + idProduct +
                ", Tên sản phẩm = '" + nameProduct + '\'' +
                ", Hãng sản xuất ='" + manufacturerProduct + '\'' +
                ", Giá sản phẩm =" + priceProduct + "VNĐ";
    }
}
