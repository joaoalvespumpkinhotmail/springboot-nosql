package com.pumpkin.nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pumpkin.nosql.model.Product;

public interface ProductRepository extends MongoRepository<Product, Long>{

}
