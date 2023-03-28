package com.pumpkin.nosql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pumpkin.nosql.model.Product;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, Long>{

    @Query("{name:'?0'}")
    Optional<Product> findByName(String productName);
}
