package model.repository;

import model.bean.Product;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepoImpl implements ProductRepo {
    BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_all_product()");

            ResultSet resultSet = callableStatement.executeQuery();

            Product product;
            while (resultSet.next()){
                product = new Product();
                product.setNameProduct(resultSet.getString("ten_sanpham"));
                product.setPriceProduct(resultSet.getDouble("gia_sanpham"));
                product.setDiscountProduct(resultSet.getDouble("giamgia_sanpham"));
                product.setStockProduct(resultSet.getInt("ton_kho"));

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public List<Product> findByDate(String start , String end) {
        List<Product> productList = new ArrayList<>();
        try {
            CallableStatement callableStatement = baseRepo.getConnection().prepareCall("call select_by_date(?,?)");
            callableStatement.setString(1,start);
            callableStatement.setString(2,end);

            ResultSet resultSet = callableStatement.executeQuery();

            Product product;
            while (resultSet.next()){
                product = new Product();
                product.setNameProduct(resultSet.getString("ten_sanpham"));
                product.setPriceProduct(resultSet.getDouble("gia_sanpham"));
                product.setDiscountProduct(resultSet.getDouble("giamgia_sanpham"));
                product.setStockProduct(resultSet.getInt("ton_kho"));

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public void addProduct(Product product) {
        try {
            CallableStatement callableStatement =
                    baseRepo.getConnection().prepareCall("call add_new_product(?,?,?,?)");
            callableStatement.setString(1,String.valueOf(product.getNameProduct()));
            callableStatement.setString(2,String.valueOf(product.getPriceProduct()));
            callableStatement.setString(3,String.valueOf(product.getDiscountProduct()));
            callableStatement.setString(4,String.valueOf(product.getStockProduct()));
            callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void topSaleProduct(int number) {

    }
}
