package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

public  interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    // New method for deleting a product by its ID
    boolean delete(String productId);
}