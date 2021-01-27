package Service;

import Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private static Map<String,Product> products;

    static {
        products = new HashMap<>();
        products.put("Lumia 520",new Product("Lumia 520","Nokia",3500
                ,"https://cdn.tgdd.vn/Products/Images/42/58119/nokia-lumia-520_clip_image001.jpg"));
        products.put("iPhone 8",new Product("iPhone 8","Apple",5000
                ,"https://thegioiapple.vn/Uploads/images/thegioiapple-mau-sac-ip8.jpg"));
        products.put("Nokia 1280",new Product("Nokia 1280","Nokia",500
                ,"https://media3.scdn.vn/img3/2019/5_7/AaXDT3_simg_de2fe0_500x500_maxb.jpg"));
        products.put("Samsung A50",new Product("Samsung A50","Samsung",2000
                ,"https://vcdn-sohoa.vnecdn.net/2019/03/11/a2-8718-1552271321.jpg"));
        products.put("Redmi note 8",new Product("Redmi note 8","Xiaomi",4000
                ,"https://bizweb.dktcdn.net/thumb/grande/100/257/835/products/xiaomi-redmi-note-8-hai-phong-01.png?v=1569298208137"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getName(),product);
    }

    @Override
    public void update(String name, Product product) {
        products.put(name,product);
    }

    @Override
    public void remove(String name) {
        products.remove(name);
    }

    @Override
    public Product search(String name) {
        return products.get(name);
    }
}
