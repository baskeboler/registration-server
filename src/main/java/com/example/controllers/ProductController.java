package com.example.controllers;

import com.example.controllers.exceptions.ProductNotFoundException;
import com.example.models.Product;
import com.example.services.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * Creado por Victor Gil<baskeboler@gmail.com>, 07/11/15.
 */
@RequestMapping(
        consumes = "application/json",
        produces = "application/json",
        path = "/api/products")
@RestController
public class ProductController {

    @Inject
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody List<Product> getAll() {
        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @ResponseBody Product getProduct(@PathVariable("id") long id) {
        return productService.getProduct(id).orElseThrow(() -> new ProductNotFoundException());
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    void deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
