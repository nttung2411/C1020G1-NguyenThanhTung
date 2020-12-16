package collection_map_tree.bai_tap.luyentap_arraylist_linkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProductManager{
//    List<Product> listProduct = new ArrayList<>();
      List<Product> listProduct = new LinkedList<>();
    public void addProduct(Product product){
        listProduct.add(product);
    }

    public void editProduct(int id , String name){
        if(listProduct.size() == 0){
            System.out.println("Chưa có sản phẩm để sửa");
        }else {
            for (Product product : listProduct) {
                if (product.getIdProduct() == id) {
                    product.setNameProduct(name);
                }
            }
        }
    }

    public void deleteProduct(int id){
        if(listProduct.size() == 0){
            System.out.println("Chưa có sản phẩm để xoá");
        }else {
            for (Product product : listProduct) {
                if (product.getIdProduct() == id) {
                    listProduct.remove(product);
                }
            }
        }
    }

    public void displayProduct(){
        for (Product product : listProduct){
            System.out.println(product);
        }
    }

    public void searchProduct(String name){
        if (listProduct.size() == 0){
            System.out.println("Chưa có sản phẩm");
        } else {
            boolean flag = false;
            for(Product product : listProduct){
                if (product.getNameProduct().equals(name)){
                    System.out.println(product);
                    flag = true;
                    break;
                }
            } if (!flag){
                System.out.println("Không tìm thấy tên sản phẩm");
            }
        }
    }

    public void sortUpCost(){
        SortUpCost sortUpCost = new SortUpCost();
        Collections.sort(listProduct,sortUpCost);
    }

    public void sortDownCost(){
        SortDownCost sortDownCost = new SortDownCost();
        Collections.sort(listProduct,sortDownCost);
    }
}
