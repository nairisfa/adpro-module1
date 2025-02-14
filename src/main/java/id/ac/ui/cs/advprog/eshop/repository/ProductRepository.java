package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    // In-memory storage for products
    private List<Product> productData = new ArrayList<>();

    // Create a new product and add it to the list
    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    // Return an iterator for all products
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    // Delete a product by its productId.
    // Returns true if the product was found and removed; otherwise false.
    public boolean delete(String productId) {
        Iterator<Product> iterator = productData.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            // Using equals() for string comparison
            if (product.getProductId() != null && product.getProductId().equals(productId)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
