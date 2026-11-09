package com.bookstore.bims.repository;

import com.bookstore.bims.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductNameContainingIgnoreCase(String name);
    List<Product> findByPriceLessThan(BigDecimal price);
}
