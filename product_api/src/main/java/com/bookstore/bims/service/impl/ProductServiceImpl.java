package com.bookstore.bims.service.impl;

import com.bookstore.bims.exception.ProductNotFoundException;
import com.bookstore.bims.models.product.Product;
import com.bookstore.bims.repository.ProductRepository;
import com.bookstore.bims.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    // CRUD methods
    public Product createProduct(Product newProduct)
    {
        return repo.save(newProduct);
    }

    public List<Product> getAllProducts()
    {
        return repo.findAll();
    }

    public Product getProductById(Long id)
    {
        return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product updateProduct(Product updatedProduct)
    {
        Product oldProduct = getProductById(updatedProduct.)
    }
}
