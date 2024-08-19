package org.example.webassignment.controller;

import org.example.webassignment.pojo.ProductPojo;
import org.example.webassignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("http://localhost:5173")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductPojo>> getAllProducts() {
        List<ProductPojo> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPojo> getProductById(@PathVariable Integer id) {
        ProductPojo product = productService.getProductById(Long.valueOf(id));
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<ProductPojo> createProduct(@RequestBody ProductPojo productPojo) {
        ProductPojo savedProduct = productService.saveProduct(productPojo);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductPojo> updateProduct(@PathVariable Integer id, @RequestBody ProductPojo productPojo) {
        productPojo.setId(Long.valueOf(id)); // Ensure the ID is set for the update
        ProductPojo updatedProduct = productService.saveProduct(productPojo);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
