package org.example.webassignment.service;

import org.example.webassignment.pojo.ProductPojo;
import java.util.List;

public interface ProductService {

    List<ProductPojo> getAllProducts();

    ProductPojo getProductById(Long id);

    ProductPojo saveProduct(ProductPojo productPojo);

    void deleteProduct(Long id);
}
