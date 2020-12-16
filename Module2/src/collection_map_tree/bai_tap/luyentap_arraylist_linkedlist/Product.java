package collection_map_tree.bai_tap.luyentap_arraylist_linkedlist;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double costProduct;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double costProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.costProduct = costProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getCostProduct() {
        return costProduct;
    }

    public void setCostProduct(double costProduct) {
        this.costProduct = costProduct;
    }

    @Override
    public String toString() {
        return "ID sản phẩm:" + getIdProduct() + " "
               +"Tên sản phẩm:" + getNameProduct() + " "
               +"Giá sản phẩm:" + getCostProduct();
    }
}
