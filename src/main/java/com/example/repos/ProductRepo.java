package com.example.repos;

import com.example.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findById(long id);
}
