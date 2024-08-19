package org.example.webassignment.service.impl;

import org.example.webassignment.Entity.Product;
import org.example.webassignment.pojo.ProductPojo;
import org.example.webassignment.repo.ProductRepository;
import org.example.webassignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductPojo> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToPojo)
                .collect(Collectors.toList());
    }

    @Override
    public ProductPojo getProductById(Long id) {
        return productRepository.findById(id)
                .map(this::convertToPojo)
                .orElse(null);
    }

    @Override
    public ProductPojo saveProduct(ProductPojo productPojo) {
        Product product = convertToEntity(productPojo);
        product = productRepository.save(product);
        return convertToPojo(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductPojo convertToPojo(Product product) {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setId(product.getId());
        productPojo.setName(product.getName());
        productPojo.setDescription(product.getDescription());
        productPojo.setImageUrl(product.getImageUrl());
        productPojo.setPrice(product.getPrice());
        productPojo.setQuantity(product.getQuantity());
        return productPojo;
    }

    private Product convertToEntity(ProductPojo productPojo) {
        Product product = new Product();
        product.setId(productPojo.getId());
        product.setName(productPojo.getName());
        product.setDescription(productPojo.getDescription());
        product.setImageUrl(productPojo.getImageUrl());
        product.setPrice(productPojo.getPrice());
        product.setQuantity(productPojo.getQuantity());
        return product;
    }
}
