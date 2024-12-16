package com.example.cassandra.springboot_cassandra_project.controller;

import com.example.cassandra.springboot_cassandra_project.ResouceNotFoundException;
import com.example.cassandra.springboot_cassandra_project.model.Product;
import com.example.cassandra.springboot_cassandra_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            Product savedProduct = productRepository.save(product);
            return ResponseEntity.ok(savedProduct);
        } catch (Exception e) {
            e.printStackTrace(); // Ajoutez une capture de l'exception pour déboguer
            throw e; // Relancez l'exception pour la gestion globale
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer productId) {
        try {
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResouceNotFoundException("Product not found with ID: " + productId));
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            e.printStackTrace(); // Ajoutez une capture de l'exception pour déboguer
            throw e; // Relancez l'exception pour la gestion globale
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer productId,
                                                 @RequestBody Product productDetails) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResouceNotFoundException("Product not found with ID: " + productId));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice()); // Assurez-vous que price est bien défini en tant que champ de la classe Product
        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResouceNotFoundException("Product not found with ID: " + productId));

        productRepository.delete(product);
        return ResponseEntity.noContent().build();
    }
}
