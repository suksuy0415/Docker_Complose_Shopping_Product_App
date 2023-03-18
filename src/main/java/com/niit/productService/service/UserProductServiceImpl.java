package com.niit.productService.service;

import com.niit.productService.domain.Customer;
import com.niit.productService.domain.Product;
import com.niit.productService.exception.UserAlreadyExistsException;
import com.niit.productService.exception.UserNotFoundException;
import com.niit.productService.exception.ProductNotFoundException;
import com.niit.productService.exception.UserAlreadyExistsException;
import com.niit.productService.repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class UserProductServiceImpl implements UserProductService{



    private UserProductRepository userProductRepository;

    @Autowired
    public UserProductServiceImpl(UserProductRepository userProductRepository) {
        this.userProductRepository = userProductRepository;
    }

    @Override
    public Customer registerUser(Customer user) throws UserAlreadyExistsException {
        if(userProductRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        return userProductRepository.save(user);
    }

    @Override
    public Customer saveUserProduct(Product product, String email) throws UserNotFoundException {
        if(userProductRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        Customer user = userProductRepository.findByEmail(email);
        if(user.getProductList() == null)
        {
            user.setProductList(Arrays.asList(product));
        }
        else {
            List<Product> products = user.getProductList();
            products.add(product);
            user.setProductList(products);
        }
        return userProductRepository.save(user);
    }

    @Override
    public Customer deleteUserProduct(String email, String productCode) throws UserNotFoundException, ProductNotFoundException {
        boolean IsPresent = false;
        if(userProductRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        Customer user = userProductRepository.findById(email).get();
        List<Product> products = user.getProductList();
        IsPresent = products.removeIf(x->x.getProductCode().equals(productCode));
        if(!IsPresent)
        {
            throw new ProductNotFoundException();
        }
        user.setProductList(products);
        return userProductRepository.save(user);
    }

    @Override
    public boolean deleteUserProduct1(String email, String productCode) throws UserNotFoundException, ProductNotFoundException {
        boolean IsPresent = false;
        if(userProductRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        Customer user = userProductRepository.findById(email).get();
        List<Product> products = user.getProductList();
        IsPresent = products.removeIf(x->x.getProductCode().equals(productCode));
        if(!IsPresent)
        {
            throw new ProductNotFoundException();
        }
        user.setProductList(products);
        return true;
    }

    @Override
    public List<Product> getAllUserProduct(String email) throws UserNotFoundException {
        if(userProductRepository.findById(email).isEmpty())
        {
            throw new UserNotFoundException();
        }
        return userProductRepository.findById(email).get().getProductList();
    }

    @Override
    public List<Product> getAllProductsAvailable(int inStock) {
        return null;
    }


}
