package Service;

import Model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    void update(String name , Product product);

    void remove(String name);

    Product search(String name);
}
