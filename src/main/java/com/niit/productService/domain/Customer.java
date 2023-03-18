package com.niit.productService.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Customer {

    @Id
    private String email;
    private String userName;

    private String password;
    private long PhoneNo;

    private List<Product> productList;


    public  Customer(){ }
    public Customer(String email, String userName, String password, long phoneNo, List<Product> productList) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        PhoneNo = phoneNo;
        this.productList = productList;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        PhoneNo = phoneNo;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", userNmae='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", PhoneNo=" + PhoneNo +
                ", productList=" + productList +
                '}';
    }
}
