package com.niit.productService.service;

import com.niit.productService.domain.Customer;
import com.niit.productService.domain.Product;
import com.niit.productService.exception.ProductNotFoundException;
import com.niit.productService.exception.UserAlreadyExistsException;
import com.niit.productService.exception.UserNotFoundException;

import java.util.List;

public interface UserProductService {
    Customer registerUser(Customer user) throws UserAlreadyExistsException;
    Customer saveUserProduct(Product product, String email) throws UserNotFoundException;

    Customer deleteUserProduct(String email, String productCode) throws UserNotFoundException, ProductNotFoundException;

    boolean deleteUserProduct1(String email, String productCode) throws UserNotFoundException, ProductNotFoundException;

    List<Product> getAllUserProduct(String email) throws UserNotFoundException;
    List<Product> getAllProductsAvailable(int inStock);

}
