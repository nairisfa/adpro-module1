
package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.Iterator;

public interface ProductRepository {
    Product create(Product product);
    Iterator<Product> findAll();
    Product findById(String productId);
    boolean update(Product updatedProduct);
    boolean delete(String productId);
}
