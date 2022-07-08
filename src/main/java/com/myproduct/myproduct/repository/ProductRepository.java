package com.myproduct.myproduct.repository;

import com.myproduct.myproduct.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findProductByName(String name);
    ProductEntity findProductByBarcode(String barcode);
    ProductEntity deleteByBarcode(String barcode);
}
