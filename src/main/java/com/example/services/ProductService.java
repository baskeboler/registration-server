package com.example.services;

import com.example.models.Product;

import java.util.List;
import java.util.Optional;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
public interface ProductService {
    Optional<Product> getProduct(long id);
    Product createProduct(Product product);
    void deleteProduct(long id);

    List<Product> getAllProducts();
}
