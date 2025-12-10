package com.hemesh.ecom_proj.controller;

import com.hemesh.ecom_proj.model.Product;
import com.hemesh.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String greet() {
        return "Hello World";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestPart Product product,
                                 @RequestPart MultipartFile image) {
        try {
            Product product1 = productService.createProduct(product, image);
            return  new ResponseEntity<>(product1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products/{id}/image")
    public ResponseEntity<byte[]> getImage(@RequestParam("id") Long id) {
        try {
            Product product = productService.getProductById(id);
            return new ResponseEntity<>(product.getImage(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestPart Product product,
                                                 @RequestPart MultipartFile image) throws IOException {
        Product product1 = productService.updateProduct(id, product, image);
        if (product1 != null) {
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } else  {
            return new ResponseEntity<>("Product not found", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword) {
        return new ResponseEntity<>(productService.searchProducts(keyword), HttpStatus.OK);
    }
}
