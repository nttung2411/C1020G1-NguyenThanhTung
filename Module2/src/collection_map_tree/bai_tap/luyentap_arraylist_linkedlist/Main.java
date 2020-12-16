package collection_map_tree.bai_tap.luyentap_arraylist_linkedlist;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1,"Nokia",500);
        Product product2 = new Product(2,"Samsung",400);
        Product product3 = new Product(3,"Xiaomi",300);
        Product product4 = new Product(4,"iPhone",600);
        Product product5 = new Product(5,"Redmi",400);

        ProductManager manager = new ProductManager();
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
        System.out.println("Trước khi sửa");
        manager.displayProduct();

        System.out.println("Sau khi sửa và sắp xếp giá tăng");
        manager.editProduct(2,"Lenovo");
        manager.sortUpCost();
        manager.displayProduct();

        System.out.println("Sắp xếp giá giảm");
        manager.sortDownCost();
        manager.displayProduct();

        System.out.println("Tìm kiếm sản phẩm");
        manager.searchProduct("Redmi");
    }
}
