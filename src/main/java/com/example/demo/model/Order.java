// Order.java
package com.example.demo.model;

import java.util.List;

public class Order {
    private String id;
    private String email;
    private List<Product> products;

    // Constructors, getters and setters
    public Order() {}

    public Order(String id, String email, List<Product> products) {
        this.id = id;
        this.email = email;
        this.products = products;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
