package com.hemesh.ecom_proj.service;

import com.hemesh.ecom_proj.model.Product;
import com.hemesh.ecom_proj.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public  Product getProductById(long id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product createProduct(Product product, MultipartFile image) {
        try {
            product.setImage(image.getBytes());
            product.setImageName(image.getOriginalFilename());
            product.setImageType(image.getContentType());
            return productRepo.save(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Product updateProduct(long id, Product product, MultipartFile image) throws IOException {
        Product product1 = productRepo.findById(id).orElse(null);
        if (product1 != null) {
            product1.setImage(image.getBytes());
            product1.setImageName(image.getOriginalFilename());
            product1.setImageType(image.getContentType());
            return productRepo.save(product1);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    public void deleteProduct(long id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String name) {
        return productRepo.findByKeyword(name);
    }
}
