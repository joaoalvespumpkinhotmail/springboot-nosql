package com.pumpkin.nosql.service;


import java.util.List;

import com.pumpkin.nosql.model.Product;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(long productId);

    void deleteProduct(long id);
}
