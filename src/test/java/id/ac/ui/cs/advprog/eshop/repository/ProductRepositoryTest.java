package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product savedProduct = products.next();

        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> products = productRepository.findAll();
        assertFalse(products.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product1.setProductName("Product 1");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("123e4567-e89b-12d3-a456-556642440001");
        product2.setProductName("Product 2");
        product2.setProductQuantity(200);
        productRepository.create(product2);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product savedProduct = products.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());

        savedProduct = products.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());

        assertFalse(products.hasNext());
    }

    @Test
    void testUpdate() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        productRepository.create(product);

        product.setProductName("Product 1 update");
        product.setProductQuantity(600);
        // Attempt to update the product.
        boolean updated = productRepository.update(product);
        // Verify that update returned true.
        assertTrue(updated);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product savedProduct = products.next();

        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    //Test Update
    @Test
    void testUpdateIfEmpty() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        // Attempt to update a non-existent product.
        boolean updated = productRepository.update(product);
        // Expect update to return false.
        assertFalse(updated);

        Iterator<Product> products = productRepository.findAll();
        assertFalse(products.hasNext());
    }

    @Test
    void testUpdateIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product1.setProductName("Product 1");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("123e4567-e89b-12d3-a456-556642440001");
        product2.setProductName("Product 2");
        product2.setProductQuantity(200);
        productRepository.create(product2);

        product1.setProductQuantity(700);
        product1.setProductName("Product 1 update");
        boolean updated = productRepository.update(product1);
        assertTrue(updated);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product savedProduct = products.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());

        savedProduct = products.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());

        assertFalse(products.hasNext());
    }

    // Test Delete
    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        productRepository.create(product);

        // Attempt to delete the product by its ID.
        boolean deleted = productRepository.delete(product.getProductId());
        // Verify deletion returns true.
        assertTrue(deleted);

        Iterator<Product> products = productRepository.findAll();
        assertFalse(products.hasNext());
    }

    @Test
    void testDeleteIfEmpty() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);

        // Attempt to delete a non-existent product.
        boolean deleted = productRepository.delete(product.getProductId());
        // Verify that deletion returns false.
        assertFalse(deleted);

        Iterator<Product> products = productRepository.findAll();
        assertFalse(products.hasNext());
    }

    @Test
    void testDeleteIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product1.setProductName("Product 1");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("123e4567-e89b-12d3-a456-556642440001");
        product2.setProductName("Product 2");
        product2.setProductQuantity(200);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductId("123e4567-e89b-12d3-a456-556642440002");
        product3.setProductName("Product 3");
        product3.setProductQuantity(300);
        productRepository.create(product3);

        // Delete the first product.
        boolean deleted = productRepository.delete(product1.getProductId());
        assertTrue(deleted);

        Iterator<Product> products = productRepository.findAll();
        assertTrue(products.hasNext());

        Product remainingProduct = products.next();
        assertEquals(product2.getProductId(), remainingProduct.getProductId());

        Product remainingProduct2 = products.next();
        assertEquals(product3.getProductId(), remainingProduct2.getProductId());

        assertFalse(products.hasNext());
    }

    @Test
    void testFindById() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product savedProduct = productRepository.findById("123e4567-e89b-12d3-a456-556642440000");

        assertEquals(product, savedProduct);
    }

    @Test
    void testFindByIdIfEmpty() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);

        Product savedProduct = productRepository.findById("123e4567-e89b-12d3-a456-556642440000");
        assertNull(savedProduct, "product is null because it does not exist");
    }

    //edit
    @Test
    void testEditSuccess() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);
        productRepository.create(product);

        product.setProductName("Product 1 editted");
        product.setProductQuantity(200);
        productRepository.update(product);

        Product edittedProduct = productRepository.findById("123e4567-e89b-12d3-a456-556642440000");
        assertNotNull(edittedProduct, "Product Exists after editting");
        assertEquals("Product 1 editted", edittedProduct.getProductName(), "Product name editted");
        assertEquals(200, edittedProduct.getProductQuantity(), "Product quantity editted");
    }

    @Test
    void testEditIfEmpty() {
        Product product = new Product();
        product.setProductId("123e4567-e89b-12d3-a456-556642440000");
        product.setProductName("Product 1");
        product.setProductQuantity(100);

        productRepository.update(product);

        Product nonExistentProduct = productRepository.findById("123e4567-e89b-12d3-a456-556642440000");
        assertNull(nonExistentProduct, "Product not found because none is added");
    }

    @Test
    void testFindByIdWithNullProductId() {
        // Create a product with a null productId
        Product product = new Product();
        product.setProductId(null);
        product.setProductName("Null Product");
        product.setProductQuantity(50);
        productRepository.create(product);

        // Attempt to find a product with a null ID; since the product's ID is null,
        // the condition in findById() won't match and it should return null.
        Product found = productRepository.findById(null);
        assertNull(found, "Should return null when searching for a product with null productId");
    }

    @Test
    void testFindByIdWithWrongProductId() {
        // Create a product with a null productId
        Product product = new Product();
        product.setProductId("");
        product.setProductName("Null Product");
        product.setProductQuantity(50);
        productRepository.create(product);

        Product found = productRepository.findById("1");
        assertNull(found, "Should return null when searching for a product with null productId");
    }

    @Test
    void testUpdateWithNullProductId() {
        // Create a product with a null productId
        Product product = new Product();
        product.setProductId(null);
        product.setProductName("Null Product");
        product.setProductQuantity(50);
        productRepository.create(product);

        // Attempt to update the product; update() should not find a matching product (because the ID is null)
        // and therefore return false.
        boolean updated = productRepository.update(product);
        assertFalse(updated, "Update should fail when productId is null");
    }

    @Test
    void testUpdateWithWrongProductId() {
        // Create a product with a null productId
        Product product = new Product();
        product.setProductId("");
        product.setProductName("Null Product");
        product.setProductQuantity(50);
        productRepository.create(product);

        Product decoy = new Product();
        decoy.setProductId("1");

        boolean updated = productRepository.update(decoy);
        assertFalse(updated, "Update should fail when productId is null");
    }


    @Test
    void testDeleteWithNullProductId() {
        // Create a product with a null productId
        Product product = new Product();
        product.setProductName("Null Product");
        product.setProductQuantity(50);
        productRepository.create(product);

        // Attempt to delete using null; the repository should not match the product with null ID,
        // so delete() should return false.
        boolean deleted = productRepository.delete("");
        assertFalse(deleted, "Delete should fail when productId is null");
    }

    @Test
    void testDeleteWithWrongProductId() {
        // Create a product with a null productId
        Product product = new Product();
        product.setProductId("");
        product.setProductName("Null Product");
        product.setProductQuantity(50);
        productRepository.create(product);

        boolean deleted = productRepository.delete("2");
        assertFalse(deleted, "Delete should fail when productId is null");
    }
}

