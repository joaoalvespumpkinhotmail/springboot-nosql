package com.pumpkin.nosql.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pumpkin.nosql.exception.ResourceNotFoundException;
import com.pumpkin.nosql.model.Product;
import com.pumpkin.nosql.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productDb = this.productRepository.findById(product.getId());

        if(productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setId(product.getId());
            productUpdate.setName(product.getName());
            productUpdate.setDescription(product.getDescription());
            productUpdate.setValor(product.getValor());
            productUpdate.setPreco_venda(product.getPreco_venda());
            productRepository.save(productUpdate);
            return productUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + product.getId());
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {

        Optional<Product> productDb = this.productRepository.findById(productId);

        if(productDb.isPresent()) {
            return productDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }

    @Override
    public void deleteProduct(long productId) {
        Optional<Product> productDb = this.productRepository.findById(productId);

        if(productDb.isPresent()) {
            this.productRepository.delete(productDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }

    }


    @Override
    public Product getProductByName(String productName) {

        Long productId = Long.valueOf(1);

        Optional<Product> productDb = this.productRepository.findByName(productName);

        if(productDb.isPresent()) {
            return productDb.get();
        }else {
            throw new ResourceNotFoundException("Record not found with Name : " + productName);
        }
    }

}
