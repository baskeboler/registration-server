package com.example.services;

import com.example.controllers.exceptions.ProductNotFoundException;
import com.example.models.Product;
import com.example.repos.ProductRepo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Inject
    private ProductRepo productRepo;

    @Override
    public Optional<Product> getProduct(long id) {
        return productRepo.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        if (!productRepo.exists(id))
            throw new ProductNotFoundException();
        productRepo.delete(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}
