package model.service;

import model.bean.Product;
import model.repository.ProductRepo;
import model.repository.ProductRepoImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepo productRepo = new ProductRepoImpl();

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public String addProduct(Product product) {

        List<Product> productList = productRepo.findAll();
        for(Product products : productList){
            if(product.getNameProduct().equals(products.getNameProduct())){
                return "Tên sản phẩm đã tồn tại";
            }
        }

        if(product.getPriceProduct()<100){
            return "Giá sản phẩm phải lớn hơn 100";
        }else if(product.getStockProduct() < 10){
            return "Hàng tồn khô ít nhất 10";
        }
        productRepo.addProduct(product);
        return "OK";
    }

    @Override
    public void topSaleProduct(int number) {

    }

    @Override
    public List<Product> findByDate(String start , String end) {
        return productRepo.findByDate(start,end);
    }
}
