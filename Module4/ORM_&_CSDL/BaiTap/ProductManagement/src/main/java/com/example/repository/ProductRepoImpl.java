package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;



@Repository
public class ProductRepoImpl implements ProductRepo {




    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery("select product from Product as product",Product.class);
        return query.getResultList();
    }

    @Override
    public void saveProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        Product product = BaseRepository.entityManager.find(Product.class,idProduct);
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }

    @Override
    public void updateProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer idProduct) {
        return BaseRepository.entityManager.find(Product.class,idProduct);
    }
}
