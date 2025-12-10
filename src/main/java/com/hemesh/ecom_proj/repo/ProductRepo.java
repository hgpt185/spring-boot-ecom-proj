package com.hemesh.ecom_proj.repo;

import com.hemesh.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE "
    + "p.name LIKE %:keyword% OR p.description LIKE %:keyword% "
    + "OR p.brand LIKE %:keyword% OR p.category LIKE %:keyword%")
    List<Product> findByKeyword(String keyword);
}
