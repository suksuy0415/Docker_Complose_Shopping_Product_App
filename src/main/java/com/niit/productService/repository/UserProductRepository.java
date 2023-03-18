package com.niit.productService.repository;

import com.niit.productService.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProductRepository extends MongoRepository<Customer,String>{

    Customer  findByEmail(String email);
}
