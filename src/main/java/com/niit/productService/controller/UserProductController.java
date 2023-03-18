package com.niit.productService.controller;

import com.niit.productService.domain.Customer;
import com.niit.productService.domain.Product;
import com.niit.productService.exception.ProductNotFoundException;
import com.niit.productService.exception.UserAlreadyExistsException;
import com.niit.productService.exception.UserNotFoundException;
import com.niit.productService.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class UserProductController {

    private ResponseEntity<?> responseEntity;
    private UserProductService userProductService;

    @Autowired

    public UserProductController(final UserProductService userProductService) {
        this.userProductService = userProductService;
    }


    @PostMapping("/")
    public ResponseEntity<?> registerUser(@RequestBody Customer user) throws UserAlreadyExistsException {
//        try {
//            responseEntity =  new ResponseEntity<>(userProductService.registerUser(user), HttpStatus.CREATED);
//        }
//        catch(UserAlreadyExistsException e)
//        {
//            throw new UserAlreadyExistsException();
//        }
        responseEntity =  new ResponseEntity<>("welcome to post method", HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("user/product/{email}")
    public ResponseEntity<?> saveUserProduct(@RequestBody Product product, @PathVariable String email) throws UserNotFoundException {
        try {
            responseEntity = new ResponseEntity<>(userProductService.saveUserProduct(product, email), HttpStatus.CREATED);
        }
        catch (UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }
    @GetMapping("user/products/{email}")
    public ResponseEntity<?> getAllUserProduct(@PathVariable String email) throws UserNotFoundException {
        try{
            responseEntity = new ResponseEntity<>(userProductService.getAllUserProduct(email), HttpStatus.OK);
        }catch(UserNotFoundException e)
        {
            throw new UserNotFoundException();
        }
        return responseEntity;
    }
    @DeleteMapping("user/{email}/{productCode}")
    public ResponseEntity<?> deleteUserProduct(@PathVariable String email,@PathVariable String productCode)
            throws UserNotFoundException, ProductNotFoundException
    {
        try {
            responseEntity = new ResponseEntity<>(userProductService.deleteUserProduct(email, productCode), HttpStatus.OK);
        } catch (UserNotFoundException | ProductNotFoundException m) {
            throw new ProductNotFoundException();
        }
        return responseEntity;
    }
}
