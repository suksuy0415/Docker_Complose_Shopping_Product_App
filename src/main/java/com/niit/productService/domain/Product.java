package com.niit.productService.domain;

public class Product {

    private String productCode;
    private String productName;
    private int inStock;

    public Product(String productCode, String productName, int inStock) {
        this.productCode = productCode;
        this.productName = productName;
        this.inStock = inStock;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
